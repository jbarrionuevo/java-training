package edu.globant.day1.multi_tier_applications.exercices.layers.dtos;

import java.util.Collection;
import java.util.Date;

import javax.validation.constraints.NotNull;

import edu.globant.day1.oop.exercices.interfaces.StoreSellerInterface;


public class StoreSellerDTO extends CaseSellerDTO implements StoreSellerInterface{

	@NotNull
	private String store;
	
	public StoreSellerDTO(){}
	
	public StoreSellerDTO(String name){
		super(name);
	}
	
	public StoreSellerDTO(String name,Collection<SaleDTO> sales, String store){
		super(name,sales);
		this.store=store;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}
}
