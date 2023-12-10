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
}
