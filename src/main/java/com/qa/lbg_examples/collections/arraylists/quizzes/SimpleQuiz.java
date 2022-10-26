package com.qa.lbg_examples.collections.arraylists.quizzes;

import com.qa.lbg_examples.collections.arraylists.Question;

//Concrete implementation of the abstract Quiz supertype
public class SimpleQuiz extends Quiz {
	
	private Question question;
	
	public SimpleQuiz(Question question) {
		if (question == null) throw new IllegalArgumentException("Question must not be null");
		this.question = question;
	}

	@Override
	protected Question getQuestion() {
		return question;
	}

	@Override
	protected boolean checkAnswer(Question question, String answer) {
		return question.checkAnswer(answer);
	}

}
