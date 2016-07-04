package edu.globant.day4.jdbc.exercises.product;

import java.util.Date;

public abstract class Price {

	private Date applicationDate;
	private Double pricePerUnit;
	
	public Price(Date applicationDate, Double pricerPerUnit) {
		this.applicationDate = applicationDate;
		this.pricePerUnit = pricerPerUnit;
	}
	
	public Date getApplicationDate() {
		return this.applicationDate;
	}
	
	public Double getPricePerUnit() {
		return this.pricePerUnit;
	}
	
	public abstract Double calculatePrice(Integer quantity);
	
}
