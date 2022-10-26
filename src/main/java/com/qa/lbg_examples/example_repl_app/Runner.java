package com.qa.lbg_examples.example_repl_app;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		CalculatorApp calcApp = new CalculatorApp(new Calculator(), new Scanner(System.in));
		calcApp.start();
	}

}
