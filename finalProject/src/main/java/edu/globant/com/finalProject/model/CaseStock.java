package edu.globant.com.finalProject.model;

public class CaseStock {
	private Case theCase;
	private int stock;
	
	public CaseStock(){
		
	}

	public Case getTheCase() {
		return theCase;
	}

	public void setTheCase(Case theCase) {
		this.theCase = theCase;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "CaseStock [theCase=" + theCase + ", stock=" + stock + "]";
	}


	
}
