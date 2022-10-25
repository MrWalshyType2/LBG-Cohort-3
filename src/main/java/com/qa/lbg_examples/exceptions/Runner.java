package com.qa.lbg_examples.exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		try {
			throwingAnException();
		} catch (CustomException ce) {
			System.out.println(ce.getMessage());
		}
	}
	
	public static void throwingAnException() throws CustomException {
		// We can throw exceptions
		// - checked exceptions must be declared in the method header
		System.out.println("About to throw an exception");
		throw new CustomException();
	}
	
	public static void scannerUncheckedExceptionHandling() {
		Scanner sc = new Scanner(System.in);
		int accumulator = 0;
		boolean isRunning = true;
		
		do {
			System.out.println("Enter 0 to quit, or a number to be accumulated");
			System.out.print("> ");
			int input;
			try {
				input = sc.nextInt();
				if (input == 0) isRunning = false;
				accumulator = accumulator + input;
			} catch (InputMismatchException ime) {
				System.out.println("Please enter a valid integer number.");
				sc.nextLine();
			}
		} while (isRunning);
		
		System.out.println("Accumulated: " + accumulator);
		System.out.println("Goodbye");
	}

	public static void simpleUncheckedExceptionHandling() {
		// try-catch blocks
		try {
			// code that may throw an exception
			int[] arr = { 1, 2, 3 };
			System.out.println(arr[3]); // ArrayIndexOutOfBoundsException
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Reached here");
	}
}
