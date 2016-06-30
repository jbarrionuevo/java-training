package edu.globant.IONSolid.model.productcases;

import java.util.Date;

import edu.globant.IONSolid.model.sale.SaleProductDetail;

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
