package edu.globant.day3.multithreading.exercises;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BankingCenter {

	static final LinkedBlockingQueue<Customer> customersQueue = new LinkedBlockingQueue<Customer>();
	static ArrayList<Customer> customers;
	
	public static void main(String[] args){
		customers = createCustomers();
		ArrayList<Runnable> tasks = new ArrayList<Runnable>();
		
		//customers entering the bank
		try {
			System.out.println("Welcome to the bank! \n");
			enterToTheBank(customersQueue, customers);
			attendPeople(customersQueue, Executors.newFixedThreadPool(4), tasks);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void attendPeople(LinkedBlockingQueue<Customer> customersqueue,ExecutorService executor, ArrayList<Runnable> tasks) throws InterruptedException {
			customers.forEach(c-> tasks.add(c.getTask().getTypeOfTask().execute(c.getName())));
		
			for (Runnable task : tasks) {
				executor.execute(task);
			}
			executor.shutdown();
		    if (!executor.awaitTermination(10000, TimeUnit.MILLISECONDS)) {
				System.out.println("Bank is closed! Bye");
		        if(customersqueue.size()>0) 
		        	System.out.println("There are some tasks to do tomorrow.");
		        System.exit(0);
		    }
		}

	private static void enterToTheBank(LinkedBlockingQueue<Customer> customersqueue,ArrayList<Customer> customers) throws InterruptedException {
		Thread enqueuer = new Thread(() -> {
			System.out.println("People entering to the bank \n");
			for (Customer c : customers) {
				try {
					Thread.sleep(1000);
					customersqueue.offer(c);
					System.out.println("Customer: "+c.getName()+" -> enqueuered");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		enqueuer.run();
		System.out.println("Starting to attend all customers");
		Thread.sleep(2000);
	}

	private static ArrayList<Customer> createCustomers() {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		
		Customer c1 = new Customer("dante",new Task(new Deposit()),new Account("12345678"));
		Customer c2 = new Customer("fede",new Task(new Borrowal()),new Account("23456789"));
		Customer c3 = new Customer("gio",new Task(new CheckAccountStatus()),new Account("34567891"));
		Customer c4 = new Customer("vicky",new Task(new Borrowal()),new Account("45678912"));
		Customer c5 = new Customer("gonza",new Task(new Deposit()),new Account("56478912"));
		Customer c6 = new Customer("pablo",new Task(new Deposit()),new Account("56478912"));
		Customer c7 = new Customer("cris",new Task(new Deposit()),new Account("56478912"));
		Customer c8 = new Customer("hernan",new Task(new Deposit()),new Account("56478912"));
		Customer c9 = new Customer("rama",new Task(new Deposit()),new Account("56478912"));
		Customer c10 = new Customer("capan",new Task(new Deposit()),new Account("56478912"));
		
		customers.add(c1);
		customers.add(c2);
		customers.add(c3);
		customers.add(c4);
		customers.add(c5);
		customers.add(c6);
		customers.add(c7);
		customers.add(c8);
		customers.add(c9);
		customers.add(c10);
		
		
		return customers;
	}
}
	
