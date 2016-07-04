package edu.globant.day4.jdbc.exercises.product;

import java.util.Date;

public class PriceWithNoDiscount extends Price {
	
	public PriceWithNoDiscount(Date applicationDate, Double price) {
		super(applicationDate, price);
	}

	@Override
	public Double calculatePrice(Integer quantity) {
		return this.getPricePerUnit() * quantity;
	}
}
