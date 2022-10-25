package com.qa.lbg_examples.file_io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;

public class Runner {

	public static void main(String[] args) {
		//simplifiedReadExample("C:\\Users\\Morgan Walsh\\eclipse-workspace\\lbg_examples\\src\\main\\java\\com\\qa\\lbg_examples\\file_io\\text_file.txt");
		//complexReadExample();
//		tryReadWithResources();
//		writeTextFile("C:\\Users\\Morgan Walsh\\eclipse-workspace\\lbg_examples\\src\\main\\java\\com\\qa\\lbg_examples\\file_io\\other_text_file.txt", "Hello\nWorld!");
//		createFile("C:\\Users\\Morgan Walsh\\eclipse-workspace\\lbg_examples\\src\\main\\java\\com\\qa\\lbg_examples\\file_io\\new_text_file.txt");
		//writeToFileWithFileOutputStream("C:\\Users\\Morgan Walsh\\eclipse-workspace\\lbg_examples\\src\\main\\java\\com\\qa\\lbg_examples\\file_io\\new_text_file.txt", "Test\nHello");
//		writeTextUsingPrintWriter();
//		writeToPositionUsingRandomAccessFile("C:\\Users\\Morgan Walsh\\eclipse-workspace\\lbg_examples\\src\\main\\java\\com\\qa\\lbg_examples\\file_io\\new_text_file.txt", "Inserted", 32);
//		readFromPositionUsingRandomAccessFile("C:\\Users\\Morgan Walsh\\eclipse-workspace\\lbg_examples\\src\\main\\java\\com\\qa\\lbg_examples\\file_io\\new_text_file.txt", 16);
	}
	
	// RandomAccessFile can be used for reading from and/or writing to a file at a specific offset (position)
	public static void writeToPositionUsingRandomAccessFile(String filename, String content, int offset) {
		try (RandomAccessFile writer = new RandomAccessFile(new File(filename), "rw")) {
			writer.seek(offset); // go to the specified position in the file
			writer.write(content.getBytes());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void readFromPositionUsingRandomAccessFile(String filename, int offset) {
		try (RandomAccessFile reader = new RandomAccessFile(new File(filename), "r")) {
			reader.seek(offset); // go to the specified position in the file
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Writing with a PrintWriter allows the use of the printf, print and println methods
	public static void writeTextUsingPrintWriter() {
		try (PrintWriter pw = new PrintWriter(new FileWriter(new File("C:\\Users\\Morgan Walsh\\eclipse-workspace\\lbg_examples\\src\\main\\java\\com\\qa\\lbg_examples\\file_io\\print_write_file.txt")))) {
			pw.printf("Hello %s, a number follows %d", "world", 32);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void appendTextToFile(String filename, String content) {
		// new FileWriter(filename, appendBoolean)
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filename), true))) {
			writer.append(content);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeTextUsingFilesStaticMethod(String filename, String content) {
		try {
			Files.write(Path.of(URI.create(filename)), content.getBytes());
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public static void writeTextFile(String filename, String content) {
		try {
			FileWriter wr = new FileWriter(filename);
			BufferedWriter bw = new BufferedWriter(wr);
			bw.write(content);
			bw.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void writeToFileWithFileOutputStream(String filename, String content) {
		try (OutputStream os = new FileOutputStream(new File(filename))) {
			os.write(content.getBytes());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void createFile(String filename) {
		try {
			File file = new File(filename);
			
			if (file.createNewFile()) System.out.println("File created successfully.");
			else System.out.println("File already exists");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public static void simplifiedReadExample(String filename) {
		try {
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			// Input and Output stream readers in Java make use of the decorator pattern
			
			String line;

			while (br.ready()) {
				line = br.readLine();
				System.out.println(line);
			} // end of while loop
			br.close(); // close the input stream
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
			// finally block is commonly used for cleaning up resources
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

}
