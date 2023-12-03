package com.project.quizz.controllers;

import com.project.quizz.entities.Question;
import com.project.quizz.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question") // by default
public class QuestionController {

    @Autowired
    QuestionService questionService;


    @GetMapping("allQuestions")
    public List<Question> getAllQuestions() {
        return questionService.getAllQUestions();
    }

    @GetMapping("category/{category}")
    public List<Question> findQuestionsByCategory(@PathVariable("category") String category){
    return questionService.findQuestionsByCategory(category);
    }

    @PostMapping("add")
    public String addQuestion (@RequestBody Question question){

        return questionService.addQuestion(question);
    }


}
