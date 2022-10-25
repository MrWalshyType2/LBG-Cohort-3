package com.qa.lbg_examples.oop.inheritance;

import java.util.Objects;

// extends is used to inherit from a class
// - Java only supports single-inheritance for classes
//   i.e., we can only inherit from one class
public class Dog extends Animal {
	
	private String name;
	
	public Dog(String name) {
		super("vertebrate");
		this.name = name;
	}
	
	public Dog(String species, String name) {
		super("vertebrate");
		this.species = species;
		this.name = name;
	}
	
	public void woof() {
		System.out.println("woof woof");
	}

	@Override
	public void makeNoise() {
		woof();
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + ", age=" + age + ", classification=" + classification + ", species=" + species
				+ ", sex=" + sex + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(name);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dog other = (Dog) obj;
		return Objects.equals(name, other.name);
	}
	
}
