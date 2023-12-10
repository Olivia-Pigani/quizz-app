package com.project.quizz.controllers;

import com.project.quizz.entities.Question;
import com.project.quizz.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("question") // by default
public class QuestionController {

    @Autowired
    QuestionService questionService;


    //READ
    @GetMapping("allQuestions")
    public List<Question> getAllQuestions() {
        return questionService.getAllQUestions();
    }

    @GetMapping("{questionId}")
    public Optional<Question> findQuestionById(@PathVariable("questionId") Integer questionId){
        return questionService.findQuestionById(questionId);
    }

    @GetMapping("category/{category}")
    public List<Question> findQuestionsByCategory(@PathVariable("category") String category) {
        return questionService.findQuestionsByCategory(category);
    }

    //CREATE

    @PostMapping("add")
    public String addQuestion(@RequestBody Question question) {

        return questionService.addQuestion(question);
    }

    //DELETE
    @DeleteMapping("delete/{categoryId}")
    public String deleteCategory(@PathVariable("categoryId") Integer categoryId) {
        return questionService.deleteCategory(categoryId);

    }
}
