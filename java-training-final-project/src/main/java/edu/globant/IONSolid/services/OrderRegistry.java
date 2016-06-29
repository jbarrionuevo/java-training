package edu.globant.IONSolid.services;

import java.util.HashMap;
import java.util.Map;

import edu.globant.IONSolid.model.Order;

public class OrderRegistry implements Registry<Order> {
	
	private Map<Long, Order> orderRegistry;
	
	public OrderRegistry() {
		this.orderRegistry = new HashMap<Long, Order>();
	}
	
	@Override
	public Order getRegister(Long id) {
		if(this.orderRegistry.containsKey(id)) {
			return this.orderRegistry.get(id);
		} 
		else {
			//Should return an exception for not found
			//Order
			return null;
		}
	}

	@Override
	public void insertRegister(Order order) {
		if(!this.orderRegistry.containsKey(order.getOrderId())) {
			this.orderRegistry.put(order.getOrderId(), order);
		}
		else {
			//Should return an exception for already exist Order
		}
		
	}

	@Override
	public void updateRegister(Order order) {
		if(isRegisterRegistered(order)) {
			this.orderRegistry.put(order.getOrderId(), order);
		}
		else {
			//Should return an exception
		}		
	}

	@Override
	public boolean isRegisterRegistered(Order order) {
		return this.orderRegistry.containsKey(order); 
	}
}
