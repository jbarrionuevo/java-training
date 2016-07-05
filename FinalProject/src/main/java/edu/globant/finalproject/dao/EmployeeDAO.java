package edu.globant.finalproject.dao;

import edu.globant.finalproject.model.Provider.OrderDTO;

public interface EmployeeDAO {
	void registerOrder(OrderDTO order);
}
