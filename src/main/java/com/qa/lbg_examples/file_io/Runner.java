package com.qa.lbg_examples.file_io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Runner {

	public static void main(String[] args) {

	}

	public static void simplifiedReadExample(String filename) {
		try {
		      FileReader fr = new FileReader(filename);
		      BufferedReader br = new BufferedReader(fr);
		      String line;

		      while (br.ready()) {
		          line = br.readLine();
		          System.out.println(line);
		      } // end of while loop
		     br.close();
		  } catch(Exception e){ // this will catch any exception
		     System.out.println(e.getMessage());
		  } // end of catch clause
	}
	
	public static void complexReadExample() {
		// Load the file, for relative paths, the following method needs to be used
		InputStream in = Runner.class.getResourceAsStream("./text_file.txt");
		BufferedReader reader = null;

		try {
			// Can also create a new InputStream directly, but must catch the FileNotFound
			// checked exception
			InputStream in2 = new FileInputStream(
					"C:\\Users\\Morgan Walsh\\eclipse-workspace\\lbg_examples\\src\\main\\java\\com\\qa\\lbg_examples\\file_io\\text_file.txt");

			reader = new BufferedReader(new InputStreamReader(in));
			String line = null;

			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (FileNotFoundException fne) {
			// must be caught before
			fne.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException npe) {
			// triggered by InputStream in if file was not available
			System.out.println("No input stream available.");
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void tryReadWithResources() {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(Runner.class.getResourceAsStream("./text_file.txt")))) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException npe) {
			// triggered by InputStream in if file was not available
			System.out.println("No input stream available.");
		}
	}
}
