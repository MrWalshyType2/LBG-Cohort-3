package com.qa.lbg_examples.oop.abstraction.quizzes;

import java.util.Scanner;

import com.qa.lbg_examples.oop.abstraction.Question;

// All methods in an interface are public and abstract
// by default
// - from Java 8, we can give methods a default implementation
//   by using the default keyword in the method header
// - an interface defines a type, just like a class does
public interface AlternateQuiz {

	default void play() {
		Scanner sc = new Scanner(System.in);
		boolean isPlaying = true;
		String input = null;
		System.out.println("The Quiz");
		System.out.println("- Keep entering answers or enter \\q to quit");
		
		do {
			Question question = getQuestion();
			System.out.println(question.getQuestionNumber() + ": " + question.getQuestion());
			System.out.print("> ");
			input = sc.nextLine();
			
			if (input.equals("\\q")) isPlaying = false;
			else if (checkAnswer(question, input)) System.out.println("Well done on getting the question correct!");
			else System.out.println("Ahh, better luck next time maybe...");
		} while (isPlaying);
	}
	
	// has to be default rather than protected, protected is not legal in an interface
	Question getQuestion();
	
	boolean checkAnswer(Question question, String answer);
}
