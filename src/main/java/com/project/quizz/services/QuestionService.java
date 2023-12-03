package com.project.quizz.services;


import com.project.quizz.dao.QuestionDao;
import com.project.quizz.entities.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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
        return "Success";
    }
}
