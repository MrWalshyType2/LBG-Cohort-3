package com.qa.lbg_examples.testing_example;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		InputUtilities inputUtils = new InputUtilities(new Scanner(System.in));
		DateConverter converter = new DateConverter();
		App app = new App(inputUtils, converter);
		app.run();
//		System.out.println(converter.toLongDate("01-11-2022", "dd-mm-yyyy"));
//		System.out.println(converter.toLongDate("11-01-2022", "mm-dd-yyyy"));
//		System.out.println(converter.toLongDate("01-13-2022", "dd-mm-yyyy"));
		
	}

}
