package com.qa.lbg_examples.oop.polymorphism;

import com.qa.lbg_examples.oop.polymorphism.quizzes.MultiItemQuiz;
import com.qa.lbg_examples.oop.polymorphism.quizzes.Quiz;
import com.qa.lbg_examples.oop.polymorphism.quizzes.SimpleQuiz;

public class Runner {

	public static void main(String[] args) {
		Quiz simpleQuiz = new SimpleQuiz(new Question(1, "What goes woof?", "dog"));
		simpleQuiz.play();
		
		Quiz multiItemQuiz = new MultiItemQuiz(new Question[] {
			new Question(1, "What goes woof?", "dog"),
			new Question(2, "What goes meow?", "cat"),
			new Question(3, "What goes moo?", "cow")
		});
		multiItemQuiz.play();
	}

}
