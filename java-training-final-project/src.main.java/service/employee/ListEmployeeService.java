package service.employee;

import domain.BaseEntity;
import domain.Employee;
import persistence.DAO.EmployeeDAO;

public class ListEmployeeService {

	private EmployeeDAO employeeDAO;

	public ListEmployeeService(EmployeeDAO employeeDAO) {
		setEmployeeDAO(employeeDAO);
	}

	private void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	public Employee findById(Long id) {
		Employee employee = (Employee) employeeDAO.findById(id);
		return employee;
	}

}
