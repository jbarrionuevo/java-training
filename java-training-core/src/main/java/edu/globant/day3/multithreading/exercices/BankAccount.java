package edu.globant.day3.multithreading.exercices;

public class BankAccount {
	private Long moneyOnAccount;
	
	public BankAccount() {
		//In order to keep things simple I
		//will intialize the accounts with the same amount
		this.moneyOnAccount = 50000L;
	}
	
	public void depositMoney(Long money) {
		this.moneyOnAccount = this.moneyOnAccount + money;
	}
	
	public Long checkMoneyOnAccount() {
		return this.moneyOnAccount;
	}
}