package ilan.dtos;

import java.util.Collection;

public class CaseSellerDTO {
	private String name;
	private Collection<SaleDTO> sales;
	
	public CaseSellerDTO(){}
	
	public CaseSellerDTO(String name){
		this.name=name;
	}
	
	public CaseSellerDTO(String name, Collection<SaleDTO> sales) {
		this.name=name;
		this.sales = sales;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<SaleDTO> getSales() {
		return sales;
	}

	public void setSales(Collection<SaleDTO> sales) {
		this.sales = sales;
	}

	
}
