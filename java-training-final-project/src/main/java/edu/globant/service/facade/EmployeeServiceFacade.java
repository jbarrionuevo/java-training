package edu.globant.service.facade;

import java.util.List;
import edu.globant.domain.Employee;
import edu.globant.persistence.DAO.EmployeeDAO;
import edu.globant.persistence.DAO.hibernate.utils.HibernateFactory;
import edu.globant.service.employee.CreateEmployeeServiceImpl;
import edu.globant.service.employee.ListEmployeeServiceImpl;
import edu.globant.service.spring.DependencyInjectorSpring;

public class EmployeeServiceFacade implements DependencyInjectorSpring, HibernateFactory {

	private CreateEmployeeServiceImpl createEmployeeService;
	private ListEmployeeServiceImpl listEmployeeService;

	public EmployeeServiceFacade(EmployeeDAO employeeDAO) {
		createEmployeeService = new CreateEmployeeServiceImpl(employeeDAO);
		listEmployeeService = new ListEmployeeServiceImpl(employeeDAO);
	}

	public void addEmployee(Employee employee) {
		createEmployeeService.create(employee);
	}

	public List<Employee> listAllEmployees() {
		return listEmployeeService.findAll();
	}

	public Employee listEmployee(Long id) {
		return listEmployeeService.findById(id);
	}
}
