package edu.globant.day6.exercises.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import edu.globant.day6.exercises.enums.Status;

@Entity
public class Sale {
	@Id
	@GeneratedValue
	private Long id;
	@OneToOne
	private Receipt receipt;
	private Status status;
	private double total;

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

}
