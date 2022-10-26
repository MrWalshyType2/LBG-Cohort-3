package com.qa.lbg_examples.oop.abstraction.quizzes;

import java.util.Random;

import com.qa.lbg_examples.oop.abstraction.Question;

// We use the 'implements' keyword for implementing an interface (or many of them)
public class AlternativeMultiItemQuiz implements AlternateQuiz {

	private Question[] questions;

	public AlternativeMultiItemQuiz(Question[] questions) {
		if (questions == null)
			throw new IllegalArgumentException("Question must not be null");
		if (questions.length == 0)
			throw new IllegalArgumentException("Must be at least one question.");
		this.questions = questions;
	}

	// has to be public as that is what the interface defines this methods
	// accessibility as
	@Override
	public Question getQuestion() {
		Random random = new Random();
		int randomNumber = random.nextInt(questions.length);
		return questions[randomNumber];
	}

	// has to be public as that is what the interface defines this methods
	// accessibility as
	@Override
	public boolean checkAnswer(Question question, String answer) {
		for (Question q : questions) {
			if (q.equals(question))
				return question.checkAnswer(answer);
		}
		throw new RuntimeException("Invalid question supplied.");
	}

	public static void main(String[] args) {
		AlternateQuiz quiz = new AlternativeMultiItemQuiz(new Question[] { new Question(1, "What goes woof?", "dog"),
				new Question(2, "What goes meow?", "cat"), new Question(3, "What goes moo?", "cow") });
		quiz.play();
	}
}
