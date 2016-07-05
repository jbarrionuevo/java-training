package edu.globant.service.employee;

import java.util.List;

import org.hibernate.Session;

import edu.globant.domain.Employee;
import edu.globant.service.ServiceImpl;
import edu.globant.service.facade.EmployeeServiceFacade;

public class EmployeeService extends ServiceImpl{
	
	EmployeeServiceFacade employeeServiceFacade;
	
	public EmployeeService(Session session) {
		super(session);
		employeeServiceFacade = new EmployeeServiceFacade(session);
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
