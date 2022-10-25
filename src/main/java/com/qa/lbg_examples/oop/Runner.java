package com.qa.lbg_examples.oop;

import com.qa.lbg_examples.oop.encapsulation.UnencapsulatedQuestion;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnencapsulatedQuestion q = new UnencapsulatedQuestion(22, "The question?", "The answer");
		q.questionNumber = 33;
		q.question = "A new question?";
//		q.answer = "inaccessible";
	}

}
