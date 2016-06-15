package edu.globant.day1.oop.exercises.model;

import java.util.Collection;

public class CaseSellers extends Employee {

	private SellerType type;
	private Collection<Sale> sales;

	public Collection<Sale> getSales() {
		return sales;
	}

	public void setSales(Collection<Sale> sales) {
		this.sales = sales;
	}
	
	public void addNewSale (Sale sale) {
		this.sales.add(sale);
	}

	public SellerType getType() {
		return type;
	}

	public void setType(SellerType type) {
		this.type = type;
	}
}
