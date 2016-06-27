package edu.globant.day3.multithreading.exercices;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class BankTeller implements Runnable {

	private BlockingQueue<Customer> customerQueue;
	private Integer tellerNumber;
	
	public BankTeller(Integer tellerNumber, BlockingQueue<Customer> customerQueue) {
		this.customerQueue = customerQueue;
		this.tellerNumber = tellerNumber;
	}

	private void handleABorrow(Customer customer) {
		try {
			System.out.println("The customer " + customer.getNumber() + " with number " + customer.getCustomerNumber()
					+ " is asking for a borrow --- " + "It's been attended by the teller " + this.tellerNumber);
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void handleADeposit(Customer customer) {
		Random random = new Random();
		Integer money = random.nextInt((5000 - 1000) + 1) + 1;
		try {
			System.out.println("The customer " + customer.getNumber() + " with number " + customer.getCustomerNumber()
					+ " is putting " + money + " on it's account --- " + "It's been attended by the teller " + this.tellerNumber);
			customer.getAccount().depositMoney(money.longValue());
			System.out.println("New Money on the account " + customer.getAccount().checkMoneyOnAccount());
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void handleACheckAccount(Customer customer) {
		try {
			System.out.println("The customer " + customer.getNumber() + " with number " + customer.getCustomerNumber()
					+ " is checking money on it's account --- " + "It's been attended by the teller " + this.tellerNumber);
			System.out.println("Money on the account " + customer.getAccount().checkMoneyOnAccount());			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// if the teller has a customer assign
		Customer customer;

		while (!this.customerQueue.isEmpty()) {
			System.out.println("-----------------------------------------------------");
			customer = customerQueue.poll();
			switch (customer.getAction()) {
			case BORROWAL:
				handleABorrow(customer);
				break;
			case CHECK_ACCOUNT:
				handleADeposit(customer);
				break;
			case DEPOSIT:
				handleACheckAccount(customer);
				break;
			}
		}
	}
	
}