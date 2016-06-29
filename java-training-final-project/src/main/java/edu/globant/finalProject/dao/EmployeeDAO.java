package edu.globant.finalProject.dao;

import edu.globant.finalProject.model.Provider.Order;

public class EmployeeDAO {

	public void registerOrder(Order order) {
		//TODO: acá grabaría en bd realmente la orden.
		System.out.println("making an order to provider: "+order.getProvider() + " of cases");
	}

}
