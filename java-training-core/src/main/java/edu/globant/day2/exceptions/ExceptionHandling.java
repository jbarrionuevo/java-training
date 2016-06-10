package edu.globant.day2.exceptions;

import static edu.globant.utils.FileUtils.getLocalResourcePath;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionHandling {

	public static void createFile(String filePath) throws IOException {
		File file = new File(filePath);
		if (!file.exists()) {
			file.createNewFile();
		}
	}

	public static void printFileContents(String filePath) throws IOException {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(filePath));
			reader.lines().forEach(System.out::println);
		} finally {
			reader.close();
		}
	}

	public static void workWithFile(String filePath) {
		try {
			createFile(filePath);
			printFileContents(filePath);
		} catch (IOException e) {
			System.out.println("There is an issue when working with the file.");
			e.printStackTrace(System.out);
		} catch (Exception e) {
			System.out.println("Unexpected exception.");
			e.printStackTrace(System.out);
		}
	}

	public static void main(String[] args) {
		workWithFile(getLocalResourcePath("/edu/globant/day2/numbers.txt"));
		workWithFile("C:/prueba.txt");
		workWithFile(null);
	}
}
