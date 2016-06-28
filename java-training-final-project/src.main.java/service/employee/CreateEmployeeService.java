package service.employee;

import domain.BaseEntity;
import domain.Employee;
import persistence.DAO.EmployeeDAO;

public class CreateEmployeeService {

	private EmployeeDAO employeeDAO;

	public CreateEmployeeService(EmployeeDAO employeeDAO) {
		// TODO Auto-generated constructor stub
		this.setEmployeeDAO(employeeDAO);
	}

	public void create(String name, String type) {
		// TODO Auto-generated method stub
		BaseEntity employee = new Employee(name, type);
		employeeDAO.save(employee);
	}

	public Employee findByName(String string, String string2) {
		// TODO Auto-generated method stub
		return null;
	}

	public EmployeeDAO getEmployeeDAO() {
		return employeeDAO;
	}

	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	public Employee findByID(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
