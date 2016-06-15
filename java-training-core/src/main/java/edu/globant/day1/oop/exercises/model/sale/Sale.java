package edu.globant.day1.oop.exercises.model.sale;

import edu.globant.day1.oop.exercises.model.sale.state.SaleState;

public class Sale {

	private SaleState state;
	
	public void setSalteState(SaleState newState) {
		this.state = newState;
	}
}
