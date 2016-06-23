package edu.globant.day1.exercises.oop.model;

import java.util.HashSet;
import java.util.Set;

public class Seller extends Employee{

	private String sellerType = SellerTypeEnum.STORE.getSellerType();
	private Set<Sale> sales = new HashSet<Sale>();
	
	public Seller() {
		super();
	}

	public String getSellerType() {
		return sellerType;
	}

	public void setSellerType(String sellerType) {
		this.sellerType = sellerType;
	}

	public Set<Sale> getSales() {
		return sales;
	}

	public void setSells(Set<Sale> sales) {
		this.sales = sales;
	}

	@Override
	public String toString() {
		return "Seller [sellerType=" + sellerType + ", sells=" + sales + "]";
	}

	
}
