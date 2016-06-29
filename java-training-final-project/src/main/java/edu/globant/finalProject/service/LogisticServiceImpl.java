package edu.globant.finalProject.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.globant.finalProject.dao.EmployeeDAO;
import edu.globant.finalProject.model.Case.Case;
import edu.globant.finalProject.model.Provider.Order;
import edu.globant.finalProject.model.Provider.Provider;
import edu.globant.finalProject.model.Sale.Sale;

@Service
public class LogisticServiceImpl implements LogisticService{
	
	@Autowired
	EmployeeDAO employeeDAO;

	@Override
	public Order createAnOrder(Provider provider) {
		//TODO: está bien esto? como lo podría manejar con el Autowired para que siempre cree una nueva instancia?
		return new Order(provider);
	}
	
	@Override
	public Order orderToProvider(Order order, ArrayList<Case> cases) {
		order.setCases(cases);
		return order;
	}

	@Transactional
	@Override
	public void registerAnOrder(Order order) {
		employeeDAO.registerOrder(order);
	}
}
