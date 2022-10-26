package com.qa.lbg_examples.collections.maps;

import java.util.Arrays;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.addMenuItem("a", new AddItem());
		menu.addMenuItem("q", new ExitItem());
		
		Scanner sc = new Scanner(System.in);
		do {
			menu.printMenu();
			System.out.print("> ");
			String input = sc.nextLine();
			String[] command = input.split(" ");
			if (command.length == 0) menu.executeOption(command[0], null);
			else menu.executeOption(command[0], Arrays.copyOfRange(command, 1, command.length));
		} while (true);
	}

}

class AddItem extends MenuItem {

	public AddItem() {
		super("Add");
	}

	@Override
	public void execute(String[] args) {
		try {
			if (args.length != 2) System.out.println("Must provide 2 numbers to add together.");
			else System.out.println("The result of adding " + args[0] + " and " + args[1] + " is " + (Double.valueOf(args[0]) + Double.valueOf(args[1])));
		} catch (NumberFormatException nfe) {
			System.out.println("You must provide numbers to add together.");
		}
	}
	
}

class ExitItem extends MenuItem {

	public ExitItem() {
		super("Exit");
	}

	@Override
	public void execute(String[] args) {
		System.out.println("Goodbye!");
		System.exit(0);
	}
	
}