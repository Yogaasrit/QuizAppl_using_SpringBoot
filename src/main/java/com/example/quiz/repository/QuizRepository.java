package com.example.quiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.quiz.entity.Quiz;


@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer>{
	
	@Query("select distinct q.category from Quiz q")
	public List<String> getUniqueCategory();
	
	@Query("SELECT q FROM Quiz q WHERE q.category = :category")
	public List<Quiz> fetchQuestions(@Param("category") String category);
	
	@Query("SELECT q.answer FROM Quiz q")
	public List<Integer> getCorrectAnswers();

}
