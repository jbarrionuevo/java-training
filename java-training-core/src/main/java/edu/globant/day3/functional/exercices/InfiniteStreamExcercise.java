package edu.globant.day3.functional.exercices;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;

class TriangleNumbersSupplier implements IntSupplier {
	int i = 1;
	@Override
	public int getAsInt() {
		int result = (i*(i+1))/2;
		i++;
		return result;
	}
};

class FactorialNumbersSupplier implements IntSupplier {
	int i = 1;
	@Override
	public int getAsInt() {
		int result = 1;
		int j = 1;
		while(j <= i) {
			result = result * j;
			j++;
		}
		i++;
		return result;
	}
};

public class InfiniteStreamExcercise {

	private static void showTriangleNumbers() {
		IntStream.generate(new TriangleNumbersSupplier())
        .limit(10)
        .forEach(System.out::println);
	}
	
	private static void showFactorialNumbers() {
		IntStream.generate(new FactorialNumbersSupplier())
        .limit(13)
        .forEach(System.out::println);
	}
	
	public static void main(String args[]) {
		showFactorialNumbers();
	}

}
