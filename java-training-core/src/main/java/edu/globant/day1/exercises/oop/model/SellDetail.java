package edu.globant.day1.exercises.oop.model;

public class SellDetail {

	private int id;
	private Sale sell;
	private Case theCase;
	private int quantity;
	
	public SellDetail(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Sale getSell() {
		return sell;
	}

	public void setSell(Sale sell) {
		this.sell = sell;
	}

	public Case getTheCase() {
		return theCase;
	}

	public void setTheCase(Case theCase) {
		this.theCase = theCase;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "SellDetail [id=" + id + ", sell=" + sell + ", theCase=" + theCase + ", quantity=" + quantity + "]";
	}
	
	
}
