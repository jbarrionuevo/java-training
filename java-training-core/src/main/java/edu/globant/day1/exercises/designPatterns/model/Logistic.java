package edu.globant.day1.exercises.designPatterns.model;

import java.util.HashSet;
import java.util.Set;

public class Logistic extends Employee {

	private Set<Alert> alerts = new HashSet<Alert>();
	private Set<Order> orders = new HashSet<Order>();
	
	public Logistic(){
		super();
	}

	public Set<Alert> getAlerts() {
		return alerts;
	}

	public void setAlerts(Set<Alert> alerts) {
		this.alerts = alerts;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
	
}
