package edu.globant.finalproject.dao;

import org.springframework.stereotype.Repository;

import edu.globant.finalproject.model.Provider.OrderDTO;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

	public void registerOrder(OrderDTO order) {
		//TODO: acá grabaría en bd realmente la orden.
		System.out.println("making an order to provider: "+order.getProvider() + " of cases");
	}

}
