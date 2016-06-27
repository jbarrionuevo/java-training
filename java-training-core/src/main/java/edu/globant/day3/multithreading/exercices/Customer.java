package edu.globant.day3.multithreading.exercices;

public class Customer {
	
	private Integer accountNumber;
	private Integer customerNumber;
	private CustomerAction customerAction;
	private BankAccount account;
	
	public Customer(Integer accountNumber, Integer customerNumber, CustomerAction action, BankAccount account) {
		this.accountNumber = accountNumber;
		this.customerAction = action;
		this.account = account;
		this.customerNumber = customerNumber;
	}
	
	public Integer getCustomerNumber() {
		return this.customerNumber;
	}
	
	public Integer getNumber() {
		return this.accountNumber;
	}
	
	public CustomerAction getAction() {
		return this.customerAction;
	}
	
	public BankAccount getAccount() {
		return this.account;
	}
}