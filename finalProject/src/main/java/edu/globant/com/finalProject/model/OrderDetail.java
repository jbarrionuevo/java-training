package edu.globant.com.finalProject.model;

public class OrderDetail {
	
	private int id;
	private Case theCase;
	private int quantity;
	
	public OrderDetail(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "OrderDetail [id=" + id + ", theCase=" + theCase + ", quantity=" + quantity + "]";
	}
	
	
}
