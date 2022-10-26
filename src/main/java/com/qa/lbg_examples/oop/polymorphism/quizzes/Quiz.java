package com.qa.lbg_examples.oop.polymorphism.quizzes;

import java.util.Scanner;

import com.qa.lbg_examples.oop.polymorphism.Question;

public class Quiz {
	
	public void play() {
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
	
	public void play(int maxRounds) {
		Scanner sc = new Scanner(System.in);
		String input = null;
		int round = 1;
		System.out.println("The Quiz");
		System.out.println("- Keep entering answers or enter \\q to quit");
		
		do {
			Question question = getQuestion();
			System.out.println(question.getQuestionNumber() + ": " + question.getQuestion());
			System.out.print("> ");
			input = sc.nextLine();
			
			if (input.equals("\\q")) {
				round++;
				break;
			}
			else if (checkAnswer(question, input)) System.out.println("Well done on getting the question correct!");
			else System.out.println("Ahh, better luck next time maybe...");
			round++;
		} while (round <= maxRounds);
		System.out.println("Goodbye, you played " + (round - 1) + " rounds.");
	}
	
	protected Question getQuestion() {
		throw new RuntimeException("Unimplemented");
	}
	
	protected boolean checkAnswer(Question question, String answer) {
		throw new RuntimeException("Unimplemented");
	}

}
