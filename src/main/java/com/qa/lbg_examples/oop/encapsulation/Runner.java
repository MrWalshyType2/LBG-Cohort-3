package com.qa.lbg_examples.oop.encapsulation;

// a class or interface at the top level can only be public or default
// in terms of its access modifier
public class Runner {

	public static void main(String[] args) {
		UnencapsulatedQuestion q1 = new UnencapsulatedQuestion(1, "What has 4 legs and woofs?", "A dog");
		
		// We can directly access and modify the data
		q1.answer = "Cat";
		
		// Encapsulation has two main implementations (agnostic of programming language):
		// - restricting of access to data/state
		// - the bundling of state and behaviours that act on that data
		
		// Java uses a combination of both
		
		// We restrict access with access modifiers:
		// - public, protected, private and default (no access modifier specified)
		
		// public means accessible everywhere
		// protected means accessible in a subclass (regardless of package) or in the same package
		// private means only accessible in the class in which it is defined
		// default means package-private, accessible by anything in the same package
		
		// Access modifiers are applied to classes, interfaces, members of those classes
		// or interfaces
		
		// Access modifiers have a order of exclusivity
		// - if a class has the default modifier, even its public fields 
		//   are then only accessible in the same package
		Question q2 = new Question(2, "What meows?", "A cat");
//		q2.answer = "A dog"; // Error, not visible
		System.out.println(q2.getQuestion());
		System.out.println(q2.checkAnswer("A cat"));
	}

}
