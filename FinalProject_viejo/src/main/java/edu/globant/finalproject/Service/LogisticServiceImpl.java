package edu.globant.finalproject.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.globant.finalproject.dao.EmployeeDAOImpl;
import edu.globant.finalproject.model.Case.CaseDTO;
import edu.globant.finalproject.model.Provider.OrderDTO;
import edu.globant.finalproject.model.Provider.ProviderDTO;

@Service
public class LogisticServiceImpl implements LogisticService{
	
	@Autowired
	EmployeeDAOImpl employeeDAO;

	@Override
	public OrderDTO createAnOrder(ProviderDTO provider) {
		//TODO: está bien esto? como lo podría manejar con el Autowired para que siempre cree una nueva instancia?
		return new OrderDTO(provider);
	}
	
	@Override
	public OrderDTO orderToProvider(OrderDTO order, ArrayList<CaseDTO> cases) {
		order.setCases(cases);
		return order;
	}

	@Transactional
	@Override
	public void registerAnOrder(OrderDTO order) {
		employeeDAO.registerOrder(order);
	}
}
