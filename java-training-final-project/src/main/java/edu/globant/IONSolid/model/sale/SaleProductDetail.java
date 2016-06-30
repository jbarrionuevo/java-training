package edu.globant.IONSolid.model.sale;

import java.util.Date;

import org.apache.commons.validator.GenericValidator;

import edu.globant.IONSolid.model.productcases.ProductCase;

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
		if(GenericValidator.minValue(quantity, 0)) {
			productQuantity = quantity;			
		}
		else {
			//If quantity negative I set it automatically to 0
			productQuantity = 0;
		}
	}

	public ProductCase getProductCase() {
		return productCase;
	}
	
	public Double getTotalPrice(Date date) {
		return productCase.getUnitPriceForDate(date, this.productQuantity);
	}
}
