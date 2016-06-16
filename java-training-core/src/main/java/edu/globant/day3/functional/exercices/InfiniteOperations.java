package edu.globant.day3.functional.exercices;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;

public class InfiniteOperations {
	public static void main(String[] args) {
		first10TriangleNumbers();
		first13FactorialNumbers();
	}
	
	public static void first10TriangleNumbers() {
		IntSupplier sumSupplier = new IntSupplier() {
			int iteration = 0;
			@Override
			public int getAsInt() {
				int result = (iteration*(iteration+1))/2;
				iteration++;
				return result;
			}
		};
		IntStream.generate(sumSupplier).limit(10)
			.forEach(System.out::println);
	}
	
	public static void first13FactorialNumbers() {
		
	}
}
