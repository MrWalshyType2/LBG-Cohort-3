package com.qa.lbg_examples.iteration;

import java.util.Scanner;

public class DoWhileLoop {

	public static void main(String[] args) {
		// a do while loop always executes
		// at least once
		Scanner sc = new Scanner(System.in);
		boolean isRunning = true;
		
		do {
			System.out.print("> ");
			String input = sc.nextLine();
			
			// switch statements do not work with all data types
			// - they work with byte, short, int, String, enum
			switch (input.toUpperCase()) {
			case "PRINT":
				System.out.println(input);
				break;
			case "EXIT":
				isRunning = false;
				break;
				// another way of forcing an exit of the program completely
				// System.exit(0);
			default:
				System.out.println("Invalid input supplied.");
				break;
			}
		} while (isRunning == true);
		
		System.out.println("Goodbye...");
	}
}
