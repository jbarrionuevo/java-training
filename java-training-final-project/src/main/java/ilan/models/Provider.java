package ilan.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Provider extends ThirdPartyParticipant implements InventoryObserver{
	
	@OneToMany
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
