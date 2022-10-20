package com.qa.lbg_examples.example_repl_app;

public class Calculator {

	/**
	 * Adds two numbers together.
	 * @param num1
	 * @param num2
	 * @return the sum of num1 and num2
	 */
	public double add(double num1, double num2) {
		return num1 + num2;
	}

	/**
	 * Multiplies two numbers together.
	 * @param num1
	 * @param num2
	 * @return the product of num1 and num2
	 */
	public double multiply(double num1, double num2) {
		return num1 * num2;
	}
	
	/**
	 * Divides two numbers.
	 * @param num1
	 * @param num2
	 * @return the quotient of num1 and num2, or 0 if num2 was 0
	 */
	public double divide(double num1, double num2) {
		if (num2 == 0) return 0;
		return num1 / num2;
	}
	
	/**
	 * Subtracts two numbers
	 * @param num1
	 * @param num2
	 * @return the difference of num1 and num2
	 */
	public double subtract(double num1, double num2) {
		return num1 - num2;
	}
}
