package com.qa.lbg_examples.testing_example;

public class App {

	private InputUtilities inputUtils;
	private DateConverter dateConverter;
	
	public App(InputUtilities inputUtilities, DateConverter dateConverter) {
		this.inputUtils = inputUtilities;
		this.dateConverter = dateConverter;
	}
	
	public void run() {
		boolean isRunning = true;
		
		do {
			printMenu();
			isRunning = executeCommand(inputUtils.getString("> "));
		} while (isRunning);
	}

	public boolean executeCommand(String input) {
		boolean output = true;
		
		try {
			switch (input.toUpperCase()) {
			case "A":
				System.out.println(dateConverter.toLongDate(inputUtils.getString("Date: "), "mm-dd-yyyy"));
				break;
			case "E":
				System.out.println(dateConverter.toLongDate(inputUtils.getString("Date: "), "dd-mm-yyyy"));
				break;
			case "Q":
				System.out.println("Thank you for using the application, goodbye!");
				output = false;
				break;
			default:
				System.out.println("Invalid command entered, please try again.");
			}
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}
		
		return output;
	}

	public void printMenu() {
		System.out.println("A) Convert short American date (mm-dd-yy) to long format");
		System.out.println("E) Convert short English date (dd-mm-yy) to long format");
		System.out.println("Q) Quit the application");
	}
}
