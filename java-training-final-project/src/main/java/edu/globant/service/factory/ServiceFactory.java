package edu.globant.service.factory;

import edu.globant.service.employee.CreateEmployeeService;
import edu.globant.service.employee.ListEmployeeService;

public interface ServiceFactory {

	CreateEmployeeService createEmployeeService();
	ListEmployeeService listEmployeeService();
}
