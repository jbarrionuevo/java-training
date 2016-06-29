package edu.globant.day1.ddd.exercises.model;

public class Sale {

	private Receipt receipt;
	private Status status;
	private double total;
	private int id;

	public Sale(Receipt receipt, Status status, double total) {
		this.receipt = receipt;
		this.status = status;
		this.total = total;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
