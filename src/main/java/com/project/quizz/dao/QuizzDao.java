package com.project.quizz.dao;

import com.project.quizz.entities.Quizz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizzDao extends JpaRepository<Quizz,Integer> {
}
