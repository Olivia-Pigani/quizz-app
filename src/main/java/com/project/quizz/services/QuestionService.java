package com.project.quizz.services;


import com.project.quizz.dao.QuestionDao;
import com.project.quizz.entities.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQUestions() {
        return questionDao.findAll();
    }


    public List<Question> findQuestionsByCategory(String category) {

        return questionDao.findByCategory(category);

    }


    public String addQuestion(Question question) {

        questionDao.save(question);
        return "The question has been posted successfully !";
    }

    public String deleteCategory(Integer categoryId) {

        questionDao.deleteById(categoryId);
        return "The question has been successfully deleted !";


    }

    public Optional<Question> findQuestionById(Integer questionId) {

        return questionDao.findById(questionId);

    }

    public String updateAQuestion(Integer questionId, Question updatedQuestion) {

        Optional<Question> questionToUpdate = findQuestionById(questionId);

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
            return "the question has been successfully updated !";
        } else {

            throw new RuntimeException("the question does not exist !");
        }


    }
}
