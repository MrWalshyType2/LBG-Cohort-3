package com.qa.lbg_examples.collections.maps;

import java.util.HashMap;
import java.util.Map;

public class Menu {
	
	// A Map stores data using key:value pairs
	// - the exact data type is a Node<K,V> where K is the data type of the key and V the type of the value
	private Map<String, MenuItem> menuItems;
	
	public Menu() {
		// A HashMap is used for efficiency purposes
		// - it makes use of the hashCode() and equals() methods of the data type used for the key
		// - these methods are specifically used for the get() and put() operations
		// - a HashMap uses a single linked list to store elements for each key, when put() is called the hashCode() is used to 
		//   used to check if a key with the same hashCode() value exists. If there is, the equals() method is used on the key.
		//   If equals() returns true, the value is overwritten, otherwise a new key:value pair is added to the singly linked list
		//   - each key is associated with a LinkedList, the LinkedList stores the values
		this.menuItems = new HashMap<String, MenuItem>();
	}
	
	public void addMenuItem(String key, MenuItem item) {
		// .put() is used to add a new key:value pair to the map
		menuItems.put(key, item);
	}
	
	public void printMenu() {
		// .keySet() returns a Set (no duplicate) elements with no particular order representing the elements in the Map
		for (String key : menuItems.keySet()) {
			// .get() is used on a map to retrieve a value by its key
			System.out.println(key + ") " + menuItems.get(key).getTitle());
		}
	}
	
	public void executeOption(String key, String[] args) {
		MenuItem item = menuItems.get(key);
		
		if (item != null) {
			item.execute(args);
		} else {
			System.out.println("Invalid menu item name supplied.");
		}
	}
}