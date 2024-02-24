package com.example.quiz.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.quiz.entity.Quiz;
import com.example.quiz.entity.User;
import com.example.quiz.service.QuizServiceImplementation;
import jakarta.servlet.http.HttpSession;

@Controller
public class QuizController {
	
	@Autowired
	QuizServiceImplementation service;
	
	@GetMapping("/")
	public String getStarted() {
		return "GetStarted";
	}
	
	@PostMapping("/enroll")
	public String enrollCandidate(@RequestParam("userName") String userName, 
			Model model, HttpSession session) {
		User user = new User();
		user.setUserName(userName);
		user.setMarks(0);
		service.enrollNewCandidate(user);
		session.setAttribute("user", user);
		List<String> list = service.getCategory();
		model.addAttribute("list",list);
		return "Quiz-Details";
	}
	
	@GetMapping("/category/{category}")
	public String displayQuestions(@PathVariable String category, Model model,
			HttpSession session) {
		User user = (User) session.getAttribute("user");
		session.setAttribute("user", user);
		session.setAttribute("category", category);
		List<Quiz> list = service.fetchQuestionsInParticularCategory(category);
		model.addAttribute("list",list);
		return "Quiz";
	}
	
	@PostMapping("/submit-quiz")
	public String getSelectedAnswers(@RequestParam Map<String,String> map, 
			HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		session.setAttribute("user", user);
		String category = (String) session.getAttribute("category");
		session.setAttribute("category", category);
		List<Integer> correctAnswer = service.getCorrectAnswer();
		int markScored = 0;
		int counter = 0;
	    for (Map.Entry<String, String> entry : map.entrySet()) {
	        String submittedAnswer = entry.getValue();
	        if(correctAnswer.get(counter) == Integer.parseInt(submittedAnswer))
	        	markScored += 1;
	        else
	        	markScored = markScored+0;
	    }
	    service.updateMark(markScored,user.getUserId());
	    List<Quiz> list = service.fetchQuestionsInParticularCategory(category);
	    model.addAttribute("markScored",markScored);
	    model.addAttribute("map",map);
	    model.addAttribute("list",list);
		return "Mark-sheet";
	}
}
