package edu.globant.day3.functional.exercises;

import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InfiniteStreams {

	private static void factorialNumbers1st13() {
		IntSupplier factorialSupplier = new IntSupplier() {
			int result = 1;
			int current = 0;

			@Override
			public int getAsInt() {
				current++;
				result = result * current;
				return result;
			}
		};
		IntStream.generate(factorialSupplier).limit(13).forEach(System.out::println);
	}

	private static void triangleNumbers1stTen() {
		System.out.println(IntStream.iterate(1, x -> x + 1)
				.map(x -> (x * (x + 1) / 2))
				.limit(10)
				.mapToObj(Integer::toString)
				.collect(Collectors.joining(",")));
	}

	public static void main(String[] args) {
		System.out.println("First 10 triangle numbers: ");
		triangleNumbers1stTen();
		System.out.println("First 13 factorial numbers: ");
		factorialNumbers1st13();
	}
}
