package edu.globant.service.employee;

import java.util.List;

import org.hibernate.Session;

import edu.globant.domain.Employee;
import edu.globant.service.GenericServiceImpl;
import edu.globant.service.facade.EmployeeServiceFacade;

public class EmployeeService extends GenericServiceImpl{
	
	EmployeeServiceFacade employeeServiceFacade;
	
	public EmployeeService() {
	}

	public void addEmployee(Employee employee) {
		employeeServiceFacade.addEmployee(employee);
	}

	public List<String> ListAllEmployees() {
		return employeeServiceFacade.ListAllEmployees();
	}
	
	public Employee findById(long id) {
		return employeeServiceFacade.ListEmployee(id);
	}
}
