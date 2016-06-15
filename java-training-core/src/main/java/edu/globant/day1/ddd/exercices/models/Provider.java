package edu.globant.day1.ddd.exercices.models;

import java.util.ArrayList;
import java.util.Collection;

public class Provider extends ThirdPartyParticipant{
	private Collection<Order> orders;
	
	public Provider(String name,String location){
		super(name,location);
		this.orders = new ArrayList<Order>();
	}
	
	public Collection<Order> getOrders() {
		return orders;
	}

	public void setOrders(Collection<Order> orders) {
		this.orders = orders;
	}
	
	public void addOrder(Order order){
		this.orders.add(order);
	}	
	
}
