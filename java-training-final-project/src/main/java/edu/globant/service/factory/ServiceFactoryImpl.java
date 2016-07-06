package edu.globant.service.factory;

import edu.globant.service.employee.CreateEmployeeService;
import edu.globant.service.employee.CreateEmployeeServiceImpl;
import edu.globant.service.employee.ListEmployeeService;
import edu.globant.service.employee.ListEmployeeServiceImpl;

public class ServiceFactoryImpl implements ServiceFactory {

	private DAOFactory daoFactory;

	public ServiceFactoryImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public CreateEmployeeService createEmployeeService() {
		return new CreateEmployeeServiceImpl(daoFactory.createEmployeeDao());
	}

	@Override
	public ListEmployeeService listEmployeeService() {
		return new ListEmployeeServiceImpl(daoFactory.createEmployeeDao());
	}
}
