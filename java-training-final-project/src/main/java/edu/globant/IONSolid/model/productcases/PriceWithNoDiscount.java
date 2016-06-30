package edu.globant.IONSolid.model.productcases;

import java.util.Date;

import edu.globant.IONSolid.model.sale.SaleProductDetail;

public class PriceWithNoDiscount extends Price {
	
	public PriceWithNoDiscount(Date applicationDate, Double price) {
		super(applicationDate, price);
	}

	@Override
	public Double calculatePrice(Integer quantity) {
		return this.getPricePerUnit() * quantity;
	}
}
