package com.qa.lbg_examples.collections.arraylists.quizzes;

import java.util.List;
import java.util.Random;

import com.qa.lbg_examples.collections.arraylists.Question;

// Concrete implementation of the abstract Quiz supertype
public class MultiItemQuiz extends Quiz {

	private List<Question> questions;
	
	public MultiItemQuiz(List<Question> questions) {
		if (questions == null) throw new IllegalArgumentException("Question must not be null");
		// List implementations use .size() rather than .length like an array
		if (questions.size() == 0) throw new IllegalArgumentException("Must be at least one question.");
		this.questions = questions;
	}
	
	@Override
	protected Question getQuestion() {
		Random random = new Random();
		int randomNumber = random.nextInt(questions.size());
		return questions.get(randomNumber); // .get() is used in a List implementation to retrieve an element by its index
	}

	@Override
	protected boolean checkAnswer(Question question, String answer) {
		for (Question q : questions) {
			if (q.equals(question)) return question.checkAnswer(answer);
		}
		throw new RuntimeException("Invalid question supplied.");
		
		// another way of iterating through a List, used if
		// you need to manipulate the data
//		for (int i = 0; i < questions.size(); i++) {
//			System.out.println(questions.get(i));
//		}
	}
}
