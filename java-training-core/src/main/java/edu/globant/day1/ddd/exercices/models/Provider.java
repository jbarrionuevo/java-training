package edu.globant.day1.ddd.exercices.models;

import java.util.ArrayList;
import java.util.Collection;

public class Provider extends ThirdPartyParticipant{
	private Collection<CaseOrder> orders;
	
	public Provider(String name,String location){
		super(name,location);
		this.orders = new ArrayList<CaseOrder>();
	}
	
	public Collection<CaseOrder> getOrders() {
		return orders;
	}

	public void setOrders(Collection<CaseOrder> orders) {
		this.orders = orders;
	}
	
	public void addOrder(CaseOrder order){
		this.orders.add(order);
	}	
	
}
