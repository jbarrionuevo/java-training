package edu.globant.day3.functional.exercices;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;

public class InfiniteOperations {
	public static void main(String[] args) {
		System.out.println("First 10 triangle numbers");
		first10TriangleNumbers();
		System.out.println("First 13 factorial numbers");
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
		IntSupplier sumSupplier = new IntSupplier() {
			int iteration = 0;
			int result = 1;
			@Override
			public int getAsInt() {
				iteration++;
				result = iteration*result;
				return result;
			}
		};
		IntStream.generate(sumSupplier).limit(10)
			.forEach(System.out::println);
	}
}
