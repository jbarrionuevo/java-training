package edu.globant.finalproject.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;

import edu.globant.finalproject.model.Provider.OrderDTO;

@Entity
@Table(name = "provider")
public class Provider extends BaseEntity{
	
	private Provider(){}
	
	public Provider(String name,List<Order> orders){
		this.name = name;
		this.orders = orders;
	}
	
	@Autowired
	@Column(name = "name")
	protected String name;
	
	@Autowired
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="provider")
    private List<Order> orders;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
