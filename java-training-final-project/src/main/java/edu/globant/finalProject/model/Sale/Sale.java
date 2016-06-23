package edu.globant.finalProject.model.Sale;

public abstract class Sale {
	private TypeOfSale typeOfSale;
	private Receipt receipt;
	private String status; 

	
	public TypeOfSale getTypeOfSale() {
		return typeOfSale;
	}

	public void setTypeOfSale(TypeOfSale typeOfSale) {
		this.typeOfSale = typeOfSale;
	}

	public Receipt getReceipt() {
		return receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}		
}
