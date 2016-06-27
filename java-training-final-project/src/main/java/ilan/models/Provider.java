package ilan.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Provider extends ThirdPartyParticipant {
	
	@OneToMany
	private Collection<Order> orders;
	
	public Provider(){}
	
	public Provider(String name,String location){
		super(name,location);
		this.orders = new ArrayList<Order>();
	}
	
	@Override
	public String toString(){
		return String.format("Name: %s. Location: %s", this.getName(), this.getLocation());
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
