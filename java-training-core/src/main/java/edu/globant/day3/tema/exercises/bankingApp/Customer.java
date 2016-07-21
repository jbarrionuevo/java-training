package edu.globant.day3.tema.exercises.bankingApp;

public class Customer {
	private String name;
	private String accountNumber;
	
	private int order;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getOrder() {
		return order;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public void setOrder(int order) {
		this.order = order;
	}		
	
	public boolean askBorrowal(){
		boolean ret = false;
		return ret; 
	}
	
	public boolean checkAccountStatus(){
		boolean ret = false;
		return ret;
	}
	
	public boolean depositMoney(){
		boolean ret = false;
		return ret;
	}
}