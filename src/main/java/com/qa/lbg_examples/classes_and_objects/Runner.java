package com.qa.lbg_examples.classes_and_objects;

public class Runner {

	public static void main(String[] args) {
		String name = "Morgan";
		
		// The 'new' keyword is used for creating
		// objects/instances of a class
		Car mazda = new Car();
		
		// We can use dot notation to access the properties inside
		// of an object
		System.out.println("=== BEFORE ===");
		System.out.println(mazda.manufacturer);
		System.out.println(mazda.numberOfWheels);
		
		// We can assign the properties new values
		mazda.manufacturer = "Mazda";
		mazda.numberOfWheels = 4;
		
		System.out.println("=== AFTER ===");
		System.out.println(mazda.manufacturer);
		System.out.println(mazda.numberOfWheels);
	}

}
