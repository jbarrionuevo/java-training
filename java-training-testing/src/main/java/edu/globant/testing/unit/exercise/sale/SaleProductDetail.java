package edu.globant.testing.unit.exercise.sale;

import edu.globant.testing.unit.exercise.sale.ProductCase;

import org.apache.commons.lang3.Validate;

public class SaleProductDetail {

	private Integer productQuantity;
	private ProductCase productCase;
	
	public SaleProductDetail(ProductCase productCase, Integer quantity) {
		Validate.notNull(productCase);
		this.productCase = productCase;
		this.setProductQuantity(quantity);
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}
	
	public void setProductQuantity(Integer quantity) {
		Validate.isTrue(quantity > 0, "The quantity should be greater than 0");
		productQuantity = quantity;			
	}

	public ProductCase getProductCase() {
		return productCase;
	}
	
	public Double getTotalPrice() {
		return productCase.getUnitPrice() * productQuantity;
	}
}
