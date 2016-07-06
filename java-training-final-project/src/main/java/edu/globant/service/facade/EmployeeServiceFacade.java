package edu.globant.service.facade;

import java.util.List;
import edu.globant.domain.Employee;
import edu.globant.persistence.DAO.EmployeeDAO;
import edu.globant.persistence.DAO.hibernate.utils.HibernateFactory;
import edu.globant.service.employee.CreateEmployeeService;
import edu.globant.service.employee.ListEmployeeService;
import edu.globant.service.spring.DependencyInjectorSpring;

public class EmployeeServiceFacade implements DependencyInjectorSpring, HibernateFactory {

	private CreateEmployeeService createEmployeeService;
	private ListEmployeeService listEmployeeService;

	public EmployeeServiceFacade(EmployeeDAO employeeDAO) {
		createEmployeeService = new CreateEmployeeService(employeeDAO);
		listEmployeeService = new ListEmployeeService(employeeDAO);
	}

	public void addEmployee(Employee employee) {
		createEmployeeService.create(employee);
	}

	public List<String> ListAllEmployees() {
		return listEmployeeService.findAllEmployees();
	}

	public Employee ListEmployee(Long id) {
		return listEmployeeService.findById(id);
	}
}
