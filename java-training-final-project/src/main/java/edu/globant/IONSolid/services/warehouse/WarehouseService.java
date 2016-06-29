package edu.globant.IONSolid.services.warehouse;

import java.util.List;

import edu.globant.IONSolid.model.Order;
import edu.globant.IONSolid.model.cases.ProductCase;
import edu.globant.IONSolid.model.registry.Registry;
import edu.globant.IONSolid.model.registry.order.OrderRegistry;

public class WarehouseService {

	private Registry<Order> orderRegistry;
	
	public WarehouseService() {
		orderRegistry = new OrderRegistry();
	}
	
	public boolean checkInventory(List<ProductCase> items) {
		return false;
		//Check if there is inventory
		//if not will return an exception
	}
	
	public void createADelivery() {
		
	}
	
	public void registerAnOrder(Order order) {
		
	}
}
