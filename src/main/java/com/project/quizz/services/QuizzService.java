package com.project.quizz.services;

import com.project.quizz.dao.QuestionDao;
import com.project.quizz.dao.QuizzDao;
import com.project.quizz.entities.Question;
import com.project.quizz.entities.Quizz;
import com.project.quizz.entities.Response;
import com.project.quizz.entities.decorators.QuestionDecorator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizzService {

    @Autowired
    QuizzDao quizzDao;

    @Autowired
    QuestionDao questionDao;


    public ResponseEntity<String> produceQuizz(String category, int nbOfQuestions, String title) {
        Quizz newQuizz = new Quizz();
        List<Question> questions = questionDao.findQuestionsByCategoryAndNb(category,nbOfQuestions);

        newQuizz.setTitle(title);
        newQuizz.setQuestions(questions);
        quizzDao.save(newQuizz);

        return new ResponseEntity<>("the quizz has been produced successfully !", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionDecorator>> getQuizzQuestions(Integer id) {
        Optional<Quizz> quizz = quizzDao.findById(id);
        List<Question> allQuestions = quizz.get().getQuestions();
        List<QuestionDecorator> questionsForUser = new ArrayList<>();
        for (Question question : allQuestions){
            QuestionDecorator questionDecorator = new QuestionDecorator(
                    question.getId(),
                    question.getQuestionTitle(),
                    question.getOption1(),
                    question.getOption2(),
                    question.getOption3(),
                    question.getOption4());

            questionsForUser.add(questionDecorator);
        }


        return new ResponseEntity<>(questionsForUser,HttpStatus.OK);


    }

    public ResponseEntity<Integer> calculateScore(Integer id, List<Response> responses) {
        int score = 0;
        int i = 0;

        Optional<Quizz> quizz = quizzDao.findById(id);
        List<Question> allQuestions = quizz.get().getQuestions();

        for (Response response : responses){
            if (response.getResponse().equals(allQuestions.get(i).getRightAnswer())) {
                score++;
            }
        }
        return new ResponseEntity<>(score,HttpStatus.OK);

    }
}
