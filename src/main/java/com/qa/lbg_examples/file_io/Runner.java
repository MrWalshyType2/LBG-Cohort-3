package com.qa.lbg_examples.file_io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
		} catch (Exception e) { // this will catch any exception
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
			// must be caught before IOException as
			// FileNotFoundException is a type of IOException
			fne.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException npe) {
			// triggered by 'InputStream in' if file was not available
			// when trying to read the file
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
		// try with resources automatically calls the .close() method
		// of resources implementing the AutoCloseable interface
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(Runner.class.getResourceAsStream("./text_file.txt")))) {
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

	public void writeTextFile(String filename, String content) {
		try {
			FileWriter wr = new FileWriter(filename);
			BufferedWriter bw = new BufferedWriter(wr);
			bw.write(content);
			bw.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
