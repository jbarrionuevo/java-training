package edu.globant.day3.multithreading.exercices;

import java.util.HashMap;
import java.util.Map;

//class BankerThreads extends Thread {
//	@Override
//	public void run() {
//		for (int i = 1; i <= LIMIT; i++) {
//			System.out.println(String.format("Hilo: %s. Data: %d", this.getName(), i));
//		}
//	}
//}

class Customer {
	
	private Long accountNumber;
	private int customerAction;
	
	public Customer(Long accountNumber, int action) {
		this.accountNumber = accountNumber;
		this.customerAction = action;
	}
	
	public Long getNumber() {
		return this.accountNumber;
	}
	
	public int getAction() {
		return this.customerAction;
	}
}

class Account {
	private Long accountNumber;
	private Double accountMoney;
	
	public Account(Long accountNumber) {
		this.accountNumber = accountNumber;
		this.accountMoney = 0.0;
	}
	
	public void depositMoney(Double money) {
		this.accountMoney = money;
	}
}

class BankAccounts {
	Map<Long, Double> customersAccounts;
	
	public BankAccounts() {
		this.customersAccounts = new HashMap<Long, Double>();
	}
	
}

public class BankExercise {

	List<>
}
