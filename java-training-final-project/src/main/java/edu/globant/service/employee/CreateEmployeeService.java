package edu.globant.service.employee;

import org.springframework.transaction.annotation.Transactional;

import edu.globant.domain.Employee;
import edu.globant.persistence.DAO.EmployeeDAO;

public class CreateEmployeeService {

	private EmployeeDAO employeeDAO;
	
	public CreateEmployeeService(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Transactional	
	public void create(Employee employee) {;
		employeeDAO.save(employee);
	}
}
