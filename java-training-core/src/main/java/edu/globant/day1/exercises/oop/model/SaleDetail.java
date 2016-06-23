package edu.globant.day1.exercises.oop.model;

public class SaleDetail {

	private int id;
	private Sale sale;
	private Case theCase;
	private int quantity;
	
	public SaleDetail(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
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
		return "SellDetail [id=" + id + ", sale=" + sale + ", theCase=" + theCase + ", quantity=" + quantity + "]";
	}
	
	
}
