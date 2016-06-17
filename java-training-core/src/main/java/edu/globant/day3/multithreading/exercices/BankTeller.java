package edu.globant.day3.multithreading.exercices;


public class BankTeller {
	private String name;

	public BankTeller(String name) {
		super();
		this.name = name;
	}
	
	public void attendClient(Customer customer) throws InterruptedException{
		System.out.println("Teller "+this.getName()+" is attending "+customer.getName());
		Thread.sleep(2500);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
