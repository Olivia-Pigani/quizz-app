package com.project.quizz.controllers;

import com.project.quizz.entities.Response;
import com.project.quizz.entities.decorators.QuestionDecorator;
import com.project.quizz.services.QuizzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quizz")
public class QuizzController {

    @Autowired
    QuizzService quizzService;

    @PostMapping("produce")
    public ResponseEntity<String> produceQuizz(@RequestParam String category, @RequestParam int nbOfQuestions, @RequestParam String title ) {
    return quizzService.produceQuizz(category,nbOfQuestions,title);
    }

    @GetMapping("getquizz/{id}")
    public ResponseEntity<List<QuestionDecorator>> getAQuizz(@PathVariable Integer id){
    return quizzService.getQuizzQuestions(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitAQuizz(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizzService.calculateScore(id,responses);
    }



}
