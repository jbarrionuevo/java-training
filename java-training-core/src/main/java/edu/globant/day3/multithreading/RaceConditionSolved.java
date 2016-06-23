package edu.globant.day3.multithreading;

import edu.globant.utils.ThreadUtils;

class SynchronizedShared {
	private volatile long x = 0;

	public long getX() {
		return x;
	}

	public void setX(long x) {
		this.x = x;
	}
}

public class RaceConditionSolved {

	static final int MAX_ITERATIONS = 20;

	public static void main(String[] args) throws Exception {
		final SynchronizedShared shared = new SynchronizedShared();
		shared.setX(1);
		Runnable task = () -> {
			for (int i = 1; i <= MAX_ITERATIONS; i++) {
				System.out.println(Thread.currentThread().getName() + ". About to increase value...");
				synchronized(shared) {
					long newValue = shared.getX() + i;
					System.out.println(String.format("%s. New value: %d + %d = %d. Instead of %d", Thread.currentThread().getName(), shared.getX(), i, newValue, shared.getX()));
					shared.setX(newValue);
				}
			}
			System.out.println(String.format("%s. Final result: %d", Thread.currentThread().getName(), shared.getX()));
		};
		ThreadUtils.executeTasksInThreadsAndWait(task, task);
		System.out.println("Final result: " + shared.getX());
	}
}
