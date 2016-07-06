package edu.globant.service.employee;

import java.util.List;
import edu.globant.domain.Employee;
import edu.globant.service.facade.EmployeeServiceFacade;

public class EmployeeServiceImpl{
	
	EmployeeServiceFacade employeeServiceFacade;
	
	public EmployeeServiceImpl() {
	}

	public void addEmployee(Employee employee) {
		employeeServiceFacade.addEmployee(employee);
	}

	public List<Employee> ListAllEmployees() {
		return employeeServiceFacade.listAllEmployees();
	}
	
	public Employee findById(long id) {
		return employeeServiceFacade.listEmployee(id);
	}
}
