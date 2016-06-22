package edu.globant.day3.multithreading.exercises;

public class Customer {

	private String name;
	private Task task;
	private Account account;
	
	public Customer(String name, Task task, Account account){
		this.name = name;
		this.task = task;
		this.account = account;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	
}
