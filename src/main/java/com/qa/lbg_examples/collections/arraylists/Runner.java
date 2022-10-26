package com.qa.lbg_examples.collections.arraylists;

import java.util.ArrayList;
import java.util.List;

import com.qa.lbg_examples.collections.arraylists.quizzes.MultiItemQuiz;
import com.qa.lbg_examples.collections.arraylists.quizzes.Quiz;
import com.qa.lbg_examples.collections.arraylists.quizzes.SimpleQuiz;

public class Runner {

	public static void main(String[] args) {
		Quiz simpleQuiz = new SimpleQuiz(new Question(1, "What goes woof?", "dog"));
		simpleQuiz.play();
		
		// List<DataType>
		// - the type of data the list stores is specified in the angle brackets (a generic type parameter)
		// - List implementations retain the order that elements were added to the list in
		List<Question> questions = new ArrayList<>();
		
		// the .add() method is used for adding elements to a List implementation
		Question q1 = new Question(1, "What goes woof?", "dog");
		questions.add(q1);
		questions.add(new Question(2, "What goes meow?", "cat"));
		questions.add(new Question(3, "What goes moo?", "cow"));
		
		// the .remove() method can be used to remove elements from mutable List implementations, such as the 
		// ArrayList. Either an index or the element to be removed are supplied in the following examples
//		questions.remove(0);
//		questions.remove(q1);
//		questions.clear(); // .clear() removes all elements from the list
//		questions.removeAll(List.of(q1)); // .removeAll() allows the removal of only elements specified in the passed in Collection type
		
		Quiz multiItemQuiz = new MultiItemQuiz(questions);
		multiItemQuiz.play();
	}

}
