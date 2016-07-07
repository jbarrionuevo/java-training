package ilan.dtos;

import java.util.ArrayList;
import java.util.Collection;

public class CaseSellerDTO {
	private String name;
	private Collection<SaleDTO> sales;
	private String store;
	
	public CaseSellerDTO(){}
	
	public CaseSellerDTO(String name, String store){
		this.name=name;
		this.sales=new ArrayList<SaleDTO>();
	}
	
	public CaseSellerDTO(String name, Collection<SaleDTO> sales, String store) {
		this.name=name;
		this.sales = sales;
		this.store=store;
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

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	
}
