package com.qa.lbg_examples.iteration;

public class WhileLoopExamples {

	public static void main(String[] args) {
		int i = 1; // i for index, for tracking our iterations (which iteration we are on)
		
		// while (boolean_expression_is_true)
		while (i <= 10) {
			System.out.println(i);
			
//			i = i + 1;
//			i += 1;
			i++; // increments i by 1
		}
		
		System.out.println("The while loop finished");
	}

}
