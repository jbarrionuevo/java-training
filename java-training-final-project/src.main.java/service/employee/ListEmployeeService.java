package service.employee;

import domain.BaseEntity;
import domain.Employee;
import persistence.DAO.EmployeeDAO;

public class ListEmployeeService {

	private EmployeeDAO<Employee> employeeDAO;

	public ListEmployeeService(EmployeeDAO<Employee> employeeDAO) {
		setEmployeeDAO(employeeDAO);
	}

	private void setEmployeeDAO(EmployeeDAO<Employee> employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	public Employee findById(Long id) {
		Employee employee = (Employee) employeeDAO.findById(id);
		return employee;
	}

}
