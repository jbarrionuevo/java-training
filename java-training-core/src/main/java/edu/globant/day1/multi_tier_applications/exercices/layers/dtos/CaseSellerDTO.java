package edu.globant.day1.multi_tier_applications.exercices.layers.dtos;

import java.util.Collection;

import javax.validation.Valid;

public abstract class CaseSellerDTO extends EmployeeDTO {
	
	//whenever a caseSeller receives an order, its a new sale with the DRAFT status; if then, the sale is not
	//succesfull, its marked as CANCELLED; otherwise, its marked as PAID, and it could then be REFUND
	@Valid
	private Collection<SaleDTO> sales;
	
	public CaseSellerDTO(){}
	
	public CaseSellerDTO(String name){
		super(name);
	}
	
	public CaseSellerDTO(String name, Collection<SaleDTO> sales) {
		super(name);
		this.sales = sales;
	}

	public void addSale(SaleDTO sale){
		this.sales.add(sale);
	}
	
	public Collection<SaleDTO> getSales() {
		return sales;
	}

	public void setSales(Collection<SaleDTO> sales) {
		this.sales = sales;
	}

	
	
}
