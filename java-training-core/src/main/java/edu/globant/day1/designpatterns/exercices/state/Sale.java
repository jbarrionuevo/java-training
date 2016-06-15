package edu.globant.day1.designpatterns.exercices.state;

import edu.globant.day1.oop.exercices.enums.SaleStatus;
import edu.globant.day1.oop.exercices.models.Order;
import edu.globant.day1.oop.exercices.models.Receipt;

public class Sale implements SaleState{
	private Receipt receipt;
	private Order order;
	private SaleState saleState;
	
	public Sale(Order order) {
		super();
		this.order=order;
		this.saleState = new DraftState();
	}
	
	public Receipt getReceipt() {
		return receipt;
	}
	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public SaleState getSaleState() {
		return saleState;
	}

	public void setSaleState(SaleState saleState) {
		this.saleState = saleState;
	}

	@Override
	public String printStatus() {
		return this.getSaleState().printStatus();
	}

	
	
	
	
}
