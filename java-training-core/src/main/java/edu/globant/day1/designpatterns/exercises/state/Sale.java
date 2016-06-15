package edu.globant.day1.designpatterns.exercises.state;

import edu.globant.day1.oop.exercises.model.Receipt;

public class Sale {

	private Receipt receipt;
	private SaleState status;
	private double total;

	public SaleState getStatus() {
		return status;
	}

	public void setStatus(SaleState status) {
		this.status = status;
	}

	public Receipt getReceipt() {
		return receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String doSomething() {
		return this.getStatus().doSomething();
	}

}
