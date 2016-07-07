package edu.globant.finalproject.model.Provider;

import java.util.ArrayList;

import javax.persistence.Id;

import org.apache.commons.lang3.Validate;

import edu.globant.finalproject.hibernate.BaseEntity;


public abstract class ProviderDTO{

	protected String name;
	protected ArrayList<OrderDTO> orders;
	
	protected ProviderDTO(String name, ArrayList<OrderDTO> orders){
		Validate.notBlank(name,"The name cannot be blank");
		Validate.notNull(orders,"orders cannot be null");
		//Validate.notEmpty(orders,"orders cannot be empty");
		
		this.name = name;
		this.orders = orders;
	}

	public String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	public ArrayList<OrderDTO> getOrders() {
		return orders;
	}

	protected void setOrders(ArrayList<OrderDTO> orders) {
		this.orders = orders;
	}
	
}
