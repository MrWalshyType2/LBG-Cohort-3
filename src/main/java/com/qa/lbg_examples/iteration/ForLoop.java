package com.qa.lbg_examples.iteration;

public class ForLoop {

	public static void main(String[] args) {
		// we use a for loop when we know how many times we want to iterate/loop
		// over something
		
		// for (initialisers; condition; increments)
		// - initialisers are evaluated once, when the loop starts
		// - the condition is checked at the beginning of each iteration
		// - the increment runs once at the end of each iteration, just before the condition is checked again
		for (int i = 0; i < 10; i++) {
			System.out.println(i + 1);
		}
		System.out.println();
		// print a 5x5 square to the console using the # sign
		// - we can only use System.out.print('#') and System.out.print('\n')
		// - they can only be used once
		for (int i = 0; i < 5; i++) {
			// nested loop
			for (int j = 0; j < 5; j++) {
				System.out.print('#');
			}
			System.out.print('\n');
		}
	}

}
