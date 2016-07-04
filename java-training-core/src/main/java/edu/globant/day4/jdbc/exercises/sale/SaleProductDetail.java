package edu.globant.day4.jdbc.exercises.sale;

import java.util.Date;

import edu.globant.day4.jdbc.exercises.product.ProductCase;

public class SaleProductDetail {

	private Integer productQuantity;
	private ProductCase productCase;
	
	public SaleProductDetail(ProductCase productCase, Integer quantity) {
		this.productCase = productCase;
		this.setProductQuantity(quantity);
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}
	
	public void setProductQuantity(Integer quantity) {
		productQuantity = 0;
	}

	public ProductCase getProductCase() {
		return productCase;
	}
	
	public Double getTotalPrice(Date date) {
		return productCase.getUnitPriceForDate(date, this.productQuantity);
	}
}
