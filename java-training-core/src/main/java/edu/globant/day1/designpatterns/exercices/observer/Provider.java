package edu.globant.day1.designpatterns.exercices.observer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import edu.globant.day1.oop.exercices.models.Case;
import edu.globant.day1.oop.exercices.models.CaseDesign;
import edu.globant.day1.oop.exercices.models.CaseDevice;
import edu.globant.day1.oop.exercices.models.Order;
import edu.globant.day1.oop.exercices.models.ThirdPartyParticipant;

public class Provider extends ThirdPartyParticipant implements InventoryObserver{
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

	@Override
	public void doUpdate(Case aCase) {
		System.out.println("Check if the provider contains aCase; if true,"
				+ "generate an auto-order for provide that case");
	}	
	
}
