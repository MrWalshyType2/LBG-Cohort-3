package com.qa.lbg_examples.example_repl_app;

import java.util.Scanner;

public class CalculatorApp {
	
	Calculator calculator;
	Scanner sc;

	public CalculatorApp(Calculator calculator, Scanner sc) {
		this.calculator = calculator;
		this.sc = sc;
	}

	public void start() {
		do {
			printMenu();
			printPrompt("> ");
			String input = sc.nextLine(); // read
			String output = evaluate(input); // eval
			System.out.println(output); // print
			
			sc.nextLine(); // consume \n which would otherwise cause weird bug, related to printing \n to console
		} while (true); // loop
	}

	private void printPrompt(String prompt) {
		System.out.print(prompt);
	}

	public void printMenu() {
		System.out.println("(A) Add\n(M) Multiply\n(S) Subtract\n(D) Divide\n(E) Exit");
	}

	public String evaluate(String command) {
		switch (command.toUpperCase()) {
		case "A":
			return executeCommand("A");
		case "M":
			return executeCommand("M");
		case "S":
			return executeCommand("S");
		case "D":
			return executeCommand("D");
		case "E":
			System.out.println("Goodbye");
			System.exit(0);
		}
		return "Invalid input, please try again...";
	}

	private String executeCommand(String command) {
		printPrompt("Number 1: ");
		double num1 = sc.nextDouble();
		printPrompt("Number 2: ");
		double num2 = sc.nextDouble();
		String output = null;
		
		switch (command.toUpperCase()) {
		case "A":
			output = "The result of adding " + num1 + " and " + num2 + " is " + String.valueOf(calculator.add(num1, num2));
			break;
		case "M":
			output = "The result of multiplying " + num1 + " and " + num2 + " is " + String.valueOf(calculator.multiply(num1, num2));
			break;
		case "S":
			output = "The result of subtract " + num2 + " from " + num1 + " is " + String.valueOf(calculator.subtract(num1, num2));
			break;
		case "D":
			output = "The result of dividing " + num1 + " by " + num2 + " is " + String.valueOf(calculator.divide(num1, num2));
			break;
		default:
			output = "Invalid command supplied...";
			break;
		}
		return output;
	}

}
