package com.example.quiz.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quiz.entity.Quiz;
import com.example.quiz.entity.User;
import com.example.quiz.repository.QuizRepository;
import com.example.quiz.repository.UserRepository;

@Service
public class QuizServiceImplementation implements QuizService{
	
	@Autowired
	QuizRepository quizrepo;
	
	@Autowired
	UserRepository userrepo;

	@Override
	public boolean enrollNewCandidate(User user) {
		userrepo.save(user);
		return true;
	}

	@Override
	public List<String> getCategory() {
		List<String> list = quizrepo.getUniqueCategory();
		return list;
	}

	@Override
	public List<Quiz> fetchQuestionsInParticularCategory(String category) {
		List<Quiz> list = quizrepo.fetchQuestions(category);
		return list;
	}

	@Override
	public List<Integer> getCorrectAnswer() {
		List<Integer> list = quizrepo.getCorrectAnswers();
		return list;
	}

	@Override
	public boolean updateMark(int mark, int userId) {
		User user = findByUserId(userId);
		user.setMarks(mark);
		return saveMark(user);
	}

	@Override
	public User findByUserId(int userId) {
		return userrepo.findById(userId).get();
	}

	@Override
	public boolean saveMark(User user) {
		userrepo.save(user);
		return true;
	}
}
