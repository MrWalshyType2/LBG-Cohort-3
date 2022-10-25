package com.qa.lbg_examples.oop.inheritance;

public class Cat extends Animal {

	public Cat(String species) {
		super("vertebrate"); // call parent class constructor
		this.species = species;
	}

	@Override
	public void makeNoise() {
		System.out.println("meow");
	}

	@Override
	public String toString() {
		return "Cat [age=" + age + ", classification=" + classification + ", species=" + species + ", sex=" + sex + "]";
	}
	
}
