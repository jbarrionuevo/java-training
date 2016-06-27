package edu.globant.day3.multithreading.exercices;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class BankExercise {

	final static int MAX_CUSTOMER = 300;
	final static int MAX_TELLER_THREADS = 4;
	
	public static void generateCustomerQueue(BlockingQueue<Customer> queue) {
		int i = 0, customerAction, accountNumber;
		Random random = new Random();
		
		while(i < MAX_CUSTOMER) {
			accountNumber = random.nextInt((99999999 - 10000000) + 1) + 10000000;
			customerAction = random.nextInt(3);
			try {
				switch(customerAction) {
					case 0:		
							queue.put(new Customer(accountNumber, i, CustomerAction.BORROWAL, new BankAccount()));
							break;
					case 1:
							queue.put(new Customer(accountNumber, i, CustomerAction.CHECK_ACCOUNT, new BankAccount()));
							break;	
					case 2:
							queue.put(new Customer(accountNumber, i, CustomerAction.DEPOSIT, new BankAccount()));
							break;									
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i++;
		}
	}
	
	public static void tellersThreadPool(ExecutorService executor, List<Runnable> tellerTasks, BlockingQueue<Customer> customerQueue) {
		System.out.println("--------------------------------------------------------------");
		System.out.println("The banck is open the tellers will attend to the customers ");
		for (Runnable tellerTask : tellerTasks) {
			executor.execute(tellerTask);
		}
		executor.shutdown();
        while (!executor.isTerminated()) {
        }
		System.out.println("--------------------------------------------------------------");
        System.out.println("Finished to attend all the customers");
	}
	
	public static void main(String args[]) {
		BlockingQueue<Customer> customerQueue = new LinkedBlockingQueue<Customer>();
		List<Runnable> tellers = new ArrayList<Runnable>();
		int i = 0;
		
		//Generates list of customers
		generateCustomerQueue(customerQueue);
		//generates bank tellers
		while(i < MAX_TELLER_THREADS) {
			tellers.add(new BankTeller(i+1, customerQueue));
			i++;
		}
	
		tellersThreadPool(Executors.newFixedThreadPool(MAX_TELLER_THREADS), tellers, customerQueue);

	}
}
