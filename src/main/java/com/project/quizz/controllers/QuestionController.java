package com.project.quizz.controllers;

import com.project.quizz.entities.Question;
import com.project.quizz.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Question>> getAllQuestions() {
        return questionService.getAllQUestions();
    }

    @GetMapping("{questionId}")
    public ResponseEntity<Optional<Question>> findQuestionById(@PathVariable("questionId") Integer questionId){
        return questionService.findQuestionById(questionId);
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> findQuestionsByCategory(@PathVariable("category") String category) {
        return questionService.findQuestionsByCategory(category);
    }

    //CREATE

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {

        return questionService.addQuestion(question);
    }


    // UPDATE
    @PutMapping("update/{questionId}")
    public ResponseEntity<String> updateAQuestion(@PathVariable("questionId") Integer questionId, @RequestBody Question updatedQuestion){
        return questionService.updateAQuestion(questionId,updatedQuestion);
    }



    //DELETE
    @DeleteMapping("delete/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable("categoryId") Integer categoryId) {
        return questionService.deleteCategory(categoryId);

    }
}
