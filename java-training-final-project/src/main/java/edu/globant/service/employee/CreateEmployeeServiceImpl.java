package edu.globant.service.employee;

import org.springframework.transaction.annotation.Transactional;
import edu.globant.domain.Employee;
import edu.globant.persistence.DAO.EmployeeDAO;
import edu.globant.persistence.DAO.GenericDAO;
import edu.globant.service.GenericServiceImpl;

public class CreateEmployeeServiceImpl extends GenericServiceImpl<Long, Employee> implements CreateEmployeeService{

	private EmployeeDAO employeeDAO;

	public CreateEmployeeServiceImpl(EmployeeDAO dao) {
		employeeDAO = dao;
	}

	@Transactional
	public void create(Employee employee) {
		employeeDAO.save(employee);
	}

	@Override
	public GenericDAO<Employee> getDao() {
		return employeeDAO;
	}
}
