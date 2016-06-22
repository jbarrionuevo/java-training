package edu.globant.day3.multithreading.exercises;

import java.util.HashSet;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.LinkedBlockingDeque;

public class BankApp {

	public static void main(String[] args) throws InterruptedException {
		Queue<Customer> queue = new LinkedBlockingDeque<Customer>(); 
		Set<Thread> tellers = new HashSet<Thread>();

		Random random = new Random();

		Thread cusQueue = new Thread(() -> {
			if (!(queue.size() > 10)) {
				int n = 1;
				while (true) {
					try {
						Thread.sleep(random.nextInt(700));//time to client come to bank
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String operation = "";
					int acc = random.nextInt(99999999);
					int rand = random.nextInt(3);
					switch (rand) {
					case 0:
						operation = "borrow";
						break;
					case 1:
						operation = "check";
						break;
					case 2:
						operation = "deposit";
						break;
					}
					queue.offer(new Customer(String.valueOf(n), operation, acc));
					System.out.println("Client " + String.valueOf(n) + " with account " + acc + " wants to " + operation);
					n++;
				}
			}
		});

		for (int i = 1; i < 4; i++) {
			Thread tellerThread = new Thread(() -> {
				Customer nextCus;
				while (true) {
					nextCus = null;
					if (queue.size() > 0) {
						nextCus = queue.poll();
					}
					if (nextCus != null) {
						System.out.println("------------------------------------------------------------------------------------");
						System.out.println("Client " + nextCus.getName() + " is asking for " + nextCus.getOperation() + " in " + String.format(Thread.currentThread().getName()));
						nextCus.operation();
					}
				}
			}, "Teller " + (i + 1));//1 thread for each teller
			tellers.add(tellerThread);// added thread to collection
		}
		tellers.stream().forEach(t -> {//starting tellers threads
			t.setDaemon(true);
			t.start();
		});
		cusQueue.setDaemon(true);//starting customer generator thread
		cusQueue.start();
		Thread.sleep(10000);
		System.out.println("--------------Finished-------------");

	}

}
