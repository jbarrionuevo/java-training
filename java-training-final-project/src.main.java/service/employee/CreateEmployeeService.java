package service.employee;

import domain.Employee;
import persistence.DAO.EmployeeDAO;

public class CreateEmployeeService {

	private EmployeeDAO<Employee> employeeDAO;

	public CreateEmployeeService(EmployeeDAO<Employee> employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	public void create(Employee employee) {;
		employeeDAO.save(employee);
	}
}
