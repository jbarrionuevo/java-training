package edu.globant.day1.exercises.ddd;

import java.util.HashSet;
import java.util.Set;

public class Seller extends Employee{

	private String sellerType = SellerTypeEnum.STORE.getSellerType();
	private Set<Sale> sells = new HashSet<Sale>();
	
	public Seller() {
		super();
	}

	public String getSellerType() {
		return sellerType;
	}

	public void setSellerType(String sellerType) {
		this.sellerType = sellerType;
	}

	public Set<Sale> getSells() {
		return sells;
	}

	public void setSells(Set<Sale> sells) {
		this.sells = sells;
	}

	@Override
	public String toString() {
		return "Seller [sellerType=" + sellerType + ", sells=" + sells + "]";
	}

	
}
