package com.project.quizz.services;


import com.project.quizz.dao.QuestionDao;
import com.project.quizz.entities.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQUestions() {
        try {

            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);

    }


    public ResponseEntity<List<Question>> findQuestionsByCategory(String category) {
        List<Question> foundedQuestion = questionDao.findByCategory(category);

        try {
            if (foundedQuestion.isEmpty()){
                return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
            }
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    public ResponseEntity<String> addQuestion(Question question) {
        try {
            questionDao.save(question);
            return new ResponseEntity<>("The question has been posted successfully !", HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("There is a problem for adding a question !", HttpStatus.BAD_REQUEST);

        }

    }

    public ResponseEntity<String> deleteCategory(Integer categoryId) {
        try {
            questionDao.deleteById(categoryId);
            return new ResponseEntity<>("The question has been successfully deleted !", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);


    }

    public ResponseEntity<Optional<Question>> findQuestionById(Integer questionId) {
        try {
            return new ResponseEntity<>(questionDao.findById(questionId), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> updateAQuestion(Integer questionId, Question updatedQuestion) {

        Optional<Question> questionToUpdate = questionDao.findById(questionId);

        try {
            if (questionToUpdate.isPresent()) {
                Question existingQuestionToUpdate = questionToUpdate.get();
                existingQuestionToUpdate.setQuestionTitle(updatedQuestion.getQuestionTitle());
                existingQuestionToUpdate.setOption1(updatedQuestion.getOption1());
                existingQuestionToUpdate.setOption2(updatedQuestion.getOption2());
                existingQuestionToUpdate.setOption3(updatedQuestion.getOption3());
                existingQuestionToUpdate.setOption4(updatedQuestion.getOption4());
                existingQuestionToUpdate.setRightAnswer(updatedQuestion.getRightAnswer());
                existingQuestionToUpdate.setDifficultyLevel(updatedQuestion.getDifficultyLevel());
                existingQuestionToUpdate.setCategory(updatedQuestion.getCategory());

                questionDao.save(existingQuestionToUpdate);
                return new ResponseEntity<>("the question has been successfully updated !", HttpStatus.OK);
            } else {

                throw new RuntimeException("the question does not exist !");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return new ResponseEntity<>("there is a problem with the question update !", HttpStatus.INTERNAL_SERVER_ERROR);


    }
}
