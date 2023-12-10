package com.project.quizz.services;

import com.project.quizz.dao.QuestionDao;
import com.project.quizz.dao.QuizzDao;
import com.project.quizz.entities.Question;
import com.project.quizz.entities.Quizz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
