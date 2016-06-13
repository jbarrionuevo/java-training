package edu.globant.day3.functional;

import java.util.Random;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InfiniteStreamDemo {

	public static void main(String[] args) {
		usingIterate();
		System.out.println("----------------------------------------------------------");
		usingSupplier();
	}

	public static void usingIterate() {
		Random random = new Random();
		System.out.println(
			IntStream.iterate(1, x -> x * 2)
				.map(x -> x - random.nextInt(x))
				.skip(5)
				.limit(10)
				.mapToObj(Integer::toString)
				.collect(Collectors.joining(","))
			);
	}

	public static void usingSupplier() {
		IntSupplier fibbonacciSupplier = new IntSupplier() {
			int previous = 0;
			int current = 1;
			@Override
			public int getAsInt() {
				int temp = previous + current;
				previous = current;
				current = temp;
				return temp;
			}
		};
		IntStream.generate(fibbonacciSupplier).limit(8)
			.forEach(System.out::println);
	}
}
