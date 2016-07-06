package ilan.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.thymeleaf.util.Validate;

@Entity
public class ThirdPartyParticipant implements Serializable{
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name,location;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "thirdPartyParticipant", cascade = CascadeType.ALL)
//	@JoinColumn(name = "provider_id")
	private Collection<CaseOrder> orders;
	
	public ThirdPartyParticipant(){}
	
	public ThirdPartyParticipant(String name,String location){
		Validate.notEmpty(name, "Name cannot be empty");
		Validate.notEmpty(location, "Location cannot be empty");
		this.name=name;
		this.location=location;
		this.orders = new ArrayList<CaseOrder>();
	}

	public void addOrder(CaseOrder order){
		this.orders.add(order);
	}

	public Collection<CaseOrder> getOrders() {
		return orders;
	}

	public void setOrders(Collection<CaseOrder> orders) {
		this.orders = orders;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
