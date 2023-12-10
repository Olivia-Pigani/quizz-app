package com.project.quizz.controllers;

import com.project.quizz.services.QuizzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("quizz")
public class QuizzController {

    @Autowired
    QuizzService quizzService;

    @PostMapping("produce")
    public ResponseEntity<String> produceQuizz(@RequestParam String category, @RequestParam int nbOfQuestions, @RequestParam String title ) {
    return quizzService.produceQuizz(category,nbOfQuestions,title);
    }


}
