package com.project.quizz.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NonNull
    private String questionTitle;

    private String option1;
    private String option2;
    private String option3;
    private String option4;

    @NonNull
    private String rightAnswer;

    private String difficultyLevel;

    @NonNull
    private String category;

    @ManyToMany(mappedBy = "questions")
    private List<Quizz> quizzes;


}
