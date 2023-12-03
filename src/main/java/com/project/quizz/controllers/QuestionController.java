package com.project.quizz.controllers;

import com.project.quizz.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;


    @GetMapping("allQuestions")
    public String getAllQuestions() {
        return questionService.getAllQUestions();
    }

}
