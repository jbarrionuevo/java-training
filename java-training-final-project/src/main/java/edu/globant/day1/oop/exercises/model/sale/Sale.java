package edu.globant.day1.oop.exercises.model.sale;

import edu.globant.day1.oop.exercises.model.sale.state.SaleState;

public class Sale {

	private SaleState state;
	private float amount;
	
	public void setSalteState(SaleState newState) {
		this.state = newState;
	}

	public SaleState getState() {
		return state;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}
}
