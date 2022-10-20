package com.qa.lbg_examples.arrays;

public class Runner {

	public static void main(String[] args) {
		// DataType[] name;
		
		// Initialise arrays with a literal syntax
		int[] ages = { 23, 80, 54, 32, 48 };
		
		// Access elements in an array by their index
		int firstElement = ages[0];
		System.out.println("First element is: " + firstElement);
		
		// arrays are a reference type, there is a property for getting the length
		int lastElement = ages[ages.length - 1];
		System.out.println("Last element is: " + lastElement);
		
		// We can also declare and initialise an array using the 'new' keyword
		// - we must specify a capacity though unless we provide an array initialiser
		String[] names = new String[10];
		
		// we can assign values directly to the array by using the index positions
		System.out.println("First element of names array before assigning new value: " + names[0]);
		names[0] = "Bob";
		System.out.println("First element of names array after assigning new value: " + names[0]);
		
		// if we supply an invalid index, we will get an error known as an IndexOutOfBoundsException
//		System.out.println(names[10]); // the last index is 9, not 10
		
		// Use loops to iterate over an array
		int[] arrayOfNumbers = new int[10];
		
		// iterate upto 1 less than the length of the array
		for (int i = 0; i < arrayOfNumbers.length; i++) {
			System.out.println("Value before initialisation on iteration " + i + " is " + arrayOfNumbers[i] + " at array position " + i);
			arrayOfNumbers[i] = i + 1;
			System.out.println("Value after initialisation on iteration " + i + " is " + arrayOfNumbers[i] + " at array position " + i);
		}
		
		// enhanced for loop
		// - if we don't need fine-grained control over the array, that is we don't need to modify its elements, but only
		//   read them, we can use an enhanced for loop to do this
		// for (DataType variableName : array) {
		//    doSomething(variableName);
		// }
		for (int number : arrayOfNumbers) {
			System.out.println(number);
		}
		
		// Arrays can also have multiple dimensions, that is they start to appear like a table
		System.out.println("2D Array example");
		int[][] twoDimensionalArray = {
				{1,  2,  3,  4},
				{5,  6,  7,  8},
				{9, 10, 11, 12}
		};
		
		// we can then use nested for loops to iterate over these arrays
		for (int row = 0; row < twoDimensionalArray.length; row++) {
			for (int column = 0; column < twoDimensionalArray[row].length; column++) {
				System.out.print(twoDimensionalArray[row][column]);
				
				if (column < twoDimensionalArray[row].length - 1) {
					System.out.print(", ");
				}
			}
			System.out.println();
		}
	}

}
