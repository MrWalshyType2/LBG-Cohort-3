package com.qa.lbg_examples.oop.encapsulation;

public class UnencapsulatedQuestion {

	// instance variables (state)
	public int questionNumber;
	public String question;
	protected String answer;
	
	public UnencapsulatedQuestion(int questionNumber, String question, String answer) {
		this.questionNumber = questionNumber;
		this.question = question;
		this.answer = answer;
	}

	// possibly instance methods that act on the state
}

