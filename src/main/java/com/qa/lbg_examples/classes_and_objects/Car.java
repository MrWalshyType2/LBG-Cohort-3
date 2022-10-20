package com.qa.lbg_examples.classes_and_objects;

public class Car {

	// Properties/state/instance variables of a class
	// AccessModifier DataType name;
	public String manufacturer;
	public int numberOfWheels;
	public int airRatio = 19;
	public int fuelRatio = 11;
	
	// All instance variables have a default value
	// - Reference types default to the 'null' value
	// - Primitive numerical types to 0
	// - Primitive char to \u0000
	// - Primitive boolean to false
	
	// Constructor
	// - name must match the name of the class
	// - there is no return type
	//   - the return type is implicit, it is the class itself
	public Car() {
		super();
	}
	
	// - we can use constructors to accept input for initialising
	//   the properties of an object
	// - we can have more than one constructor, constructor overloading
	// - if we have more than one constructor, it must have different
	//   parameter types
	public Car(String manufacturer, int numberOfWheels) {
		// we have a special keyword called 'this' which is used
		// to refer to the current object
		// - this.manufacturer is referring to the variable on line 7
		this.manufacturer = manufacturer;
		this.numberOfWheels = numberOfWheels;
	}

	// Methods
	// - a non static method is an instance method, it belongs
	//   to an object and can only be called from an object
	// - instance methods represent the behaviours of an object
	public void accelerate(int percent) {
		if (percent < 25) {
			airRatio = 19;
			System.out.println(manufacturer + " Slow acceleration or stopped");
		} else if (percent < 75) {
			airRatio = 15;
			System.out.println(manufacturer + " Medium acceleration");
		} else {
			airRatio = 11;
			System.out.println(manufacturer + " Fast acceleration");
		}
	}
	
	public String getInformation() {
		return "MANUFACTURER=" + manufacturer + ", AIR:FUEL RATIO: " + 
				airRatio + ":" + fuelRatio;
	}
}
