package ilan.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Provider extends ThirdPartyParticipant implements InventoryObserver{
	
	@OneToMany
	private Collection<CaseOrder> orders;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "provider", cascade = CascadeType.ALL)
	private Collection<CaseProduct> cases;
	
	public Provider(){}
	
	public Provider(String name,String location){
		super(name,location);
		this.orders = new ArrayList<CaseOrder>();
	}
	
	@Override
	public String toString(){
		return String.format("Name: %s. Location: %s", this.getName(), this.getLocation());
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

	@Override
	public void doUpdate(CaseProduct aCase) {
		System.out.println("Check if the provider contains aCase; if true,"
				+ "generate an auto-order for provide that case");
	}

	public Collection<CaseProduct> getCases() {
		return cases;
	}

	public void setCases(Collection<CaseProduct> cases) {
		this.cases = cases;
	}	
	
	
}
