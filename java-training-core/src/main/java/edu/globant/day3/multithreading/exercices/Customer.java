package edu.globant.day3.multithreading.exercices;

public class Customer{
	private String name,bankAction;
	private long accountNumber;
	private static int customerNumber = 0;
	
	public static int getCustomerNumber(){
		customerNumber++;
		return customerNumber;
	}
	
	public Customer(String name,String bankAction) {
		super();
		this.name = name;
		this.bankAction=bankAction;
	}
	
	public void makeAction(){
		switch (this.getBankAction()) {
		case "borrow":
			this.askForBorrowal();
			break;
		case "deposit":
			this.depositMoney();;
			break;
		default:
			this.checkAccountStatus();
			break;
		}
	}
	
	public void askForBorrowal(){
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void checkAccountStatus(){
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void depositMoney(){
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString(){
		return String.format("Client %s", this.getName());
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBankAction() {
		return bankAction;
	}

	public void setBankAction(String bankAction) {
		this.bankAction = bankAction;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	
}
