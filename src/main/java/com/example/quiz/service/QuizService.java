package com.example.quiz.service;

import java.util.List;
import com.example.quiz.entity.Quiz;
import com.example.quiz.entity.User;

public interface QuizService {
	
	public boolean enrollNewCandidate(User user);
	public List<String> getCategory();
	public List<Quiz> fetchQuestionsInParticularCategory(String category);
	public List<Integer> getCorrectAnswer();
	public boolean updateMark(int mark, int userId);
	public User findByUserId(int userId);
	public boolean saveMark(User user);
}
