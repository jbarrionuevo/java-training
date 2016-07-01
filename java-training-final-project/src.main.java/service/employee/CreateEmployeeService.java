package service.employee;

import org.springframework.transaction.annotation.Transactional;

import domain.Employee;
import persistence.DAO.EmployeeDAO;

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
