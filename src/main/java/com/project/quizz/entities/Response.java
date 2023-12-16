package com.project.quizz.entities;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Response {


    private Integer id;

    @NonNull
    private String response;



}
