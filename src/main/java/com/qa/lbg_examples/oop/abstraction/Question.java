package com.qa.lbg_examples.oop.abstraction;

import java.util.Objects;

public class Question {

	private int questionNumber;
	private String question;
	private String answer;
	
	public Question(int questionNumber, String question, String answer) {
		this.questionNumber = questionNumber;
		this.question = question;
		this.answer = answer;
	}
	
	public boolean checkAnswer(String answer) {
		if (this.answer.equals(answer)) return true;
		return false;
	}

	public int getQuestionNumber() {
		return questionNumber;
	}

	public String getQuestion() {
		return question;
	}

	@Override
	public String toString() {
		return "Question [questionNumber=" + questionNumber + ", question=" + question + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(answer, question, questionNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		return Objects.equals(answer, other.answer) && Objects.equals(question, other.question)
				&& questionNumber == other.questionNumber;
	}
	
}
