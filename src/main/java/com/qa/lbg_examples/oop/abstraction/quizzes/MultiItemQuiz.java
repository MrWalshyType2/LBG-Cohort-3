package com.qa.lbg_examples.oop.abstraction.quizzes;

import java.util.Random;

import com.qa.lbg_examples.oop.abstraction.Question;

// Concrete implementation of the abstract Quiz supertype
public class MultiItemQuiz extends Quiz {

	private Question[] questions;
	
	public MultiItemQuiz(Question[] questions) {
		if (questions == null) throw new IllegalArgumentException("Question must not be null");
		if (questions.length == 0) throw new IllegalArgumentException("Must be at least one question.");
		this.questions = questions;
	}
	
	@Override
	protected Question getQuestion() {
		Random random = new Random();
		int randomNumber = random.nextInt(questions.length);
		return questions[randomNumber];
	}

	@Override
	protected boolean checkAnswer(Question question, String answer) {
		for (Question q : questions) {
			if (q.equals(question)) return question.checkAnswer(answer);
		}
		throw new RuntimeException("Invalid question supplied.");
	}
}
