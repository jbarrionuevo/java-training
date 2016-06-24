package edu.globant.day6.exercises.model;

import java.util.Collection;

public class Provider {

	private Collection<Order> orders;

	public Collection<Order> getOrders() {
		return orders;
	}

	public void setOrders(Collection<Order> orders) {
		this.orders = orders;
	}

	public void addOrder(Order order) {
		this.orders.add(order);
	}
}
