package service.employee;

import domain.Employee;
import persistence.DAO.EmployeeDAO;

public class CreateEmployeeService {

	private EmployeeDAO employeeDAO;

	public CreateEmployeeService(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	public void create(Employee employee) {;
		employeeDAO.save(employee);
	}
}
