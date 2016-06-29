package edu.globant.finalProject.model.Provider;

import java.util.ArrayList;

import javax.persistence.Id;

import org.apache.commons.lang3.Validate;

import edu.globant.finalProject.hibernate.BaseEntity;

public abstract class Provider extends BaseEntity{

	protected String name;
	protected ArrayList<Order> orders;
	
	protected Provider(String name, ArrayList<Order> orders){
		Validate.notBlank(name,"The name cannot be blank");
		Validate.notNull(orders,"orders cannot be null");
		Validate.notEmpty(orders,"orders cannot be empty");
		
		this.name = name;
		this.orders = orders;
	}

	public String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	public ArrayList<Order> getOrders() {
		return orders;
	}

	protected void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
	
}
