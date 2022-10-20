package com.qa.lbg_examples.iteration;

import java.util.Scanner;

public class ExerciseSolutions {

	public static void main(String[] args) {
//		printOneToTen();
//		whileLoopExample();
		printOneToTenAsManyTimesAsTheCurrentNumber();
	}
	
	// Create a method to print the numbers 1 to 10 as many times as the value of that number, similar to the output below:
	public static void printOneToTenAsManyTimesAsTheCurrentNumber() {
		for (int i = 1; i <= 10; i++) {
			
			for (int j = 0; j < i; j++) {
				System.out.print(i);
			}
//			System.out.print("\n");
			System.out.println();
		}
	}

	public static void printOneToTen() {
		int i = 1;
		
		while (i <= 10) {
			System.out.println(i);
			i++;
		}
	}
	
	public static void whileLoopExample() {
	    System.out.println("Enter your name ");
	    Scanner scan = new Scanner(System.in);
	    String name = scan.nextLine();
	    System.out.println("How many times do you want us to print your name? ");
	    int count = scan.nextInt();

	    do {
	    	if (count > 0) {
	    		System.out.println(name);
	    		count--;
	    	}
	    } while (count > 0);
	    
//	    while(count > 0) {
//	        System.out.println(name);
//	        count--;
//	    }
	}
}
