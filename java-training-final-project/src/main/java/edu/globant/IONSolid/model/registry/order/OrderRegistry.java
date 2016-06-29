package edu.globant.IONSolid.model.registry.order;

import java.util.HashMap;
import java.util.Map;

import edu.globant.IONSolid.model.Order;
import edu.globant.IONSolid.model.registry.Registry;
import edu.globant.IONSolid.model.registry.exception.NotFoundRegisterException;

public class OrderRegistry implements Registry<Long, Order> {
	
	private Map<Long, Order> orderRegistry;
	
	public OrderRegistry() {
		this.orderRegistry = new HashMap<Long, Order>();
	}
	
	@Override
	public Order getRegister(Long orderId) throws NotFoundRegisterException {
		if(this.isRegisterRegisteredById(orderId)) {
			return this.orderRegistry.get(orderId);
		} 
		else {
			throw new NotFoundRegisterException("The order: " + orderId + " was not found");
		}
	}

	@Override
	public void insertRegister(Order order) throws NotFoundRegisterException {
		if(!this.orderRegistry.containsKey(order.getOrderId())) {
			this.orderRegistry.put(order.getOrderId(), order);
		}
		else {
			throw new NotFoundRegisterException("The order: " + order.getOrderId() + " was not found");
		}	
	}

	@Override
	public void updateRegister(Order order) throws NotFoundRegisterException {
		if(isRegisterRegistered(order)) {
			this.orderRegistry.put(order.getOrderId(), order);
		}
		else {
			throw new NotFoundRegisterException("The order: " + order.getOrderId() + " was not found");
		}		
	}

	@Override
	public boolean isRegisterRegistered(Order order) {
		return this.isRegisterRegisteredById(order.getOrderId()); 
	}

	@Override
	public Map<Long, Order> getAllRegisters() {
		return this.orderRegistry;
	}

	@Override
	public boolean isRegisterRegisteredById(Long orderId) {
		return this.orderRegistry.containsKey(orderId); 
	}
}
