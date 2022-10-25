package com.qa.lbg_examples.oop.inheritance;

public class Runner {

	public static void main(String[] args) {
		Animal dog = new Animal("vertebrate");
		dog.setAge(15);
		System.out.println(dog.toString());
		
		Animal dog2 = new Animal("vertebrate");
		dog2.setAge(15);
		System.out.println(dog2);
		System.out.println("Dog1 and dog2 are equal: " + dog.equals(dog2));
		Object obj = dog;
//		obj.setAge(4); // can't use as we lost the information
		System.out.println(dog.getClass());
		
		Dog actualDog = new Dog("Bob");
		System.out.println(actualDog);
		actualDog.makeNoise();
		
		// subtype polymorphism
		Animal actualDogInAnAnimalVariable = actualDog;
		actualDogInAnAnimalVariable.makeNoise();
	}

}
