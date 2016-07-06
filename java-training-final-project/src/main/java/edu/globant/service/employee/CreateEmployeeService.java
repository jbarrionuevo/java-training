package edu.globant.service.employee;

import org.springframework.transaction.annotation.Transactional;
import edu.globant.domain.Employee;
import edu.globant.persistence.DAO.EmployeeDAO;
import edu.globant.service.GenericServiceImpl;
import edu.globant.service.spring.DependencyInjectorSpring;

public class CreateEmployeeService extends GenericServiceImpl implements DependencyInjectorSpring {

	private EmployeeDAO employeeDAO;

	public CreateEmployeeService(EmployeeDAO dao) {
		this.employeeDAO = dao;
		// super(session);
		// this.employeeDAO = new EmployeeDAOImpl(session);

	}

	@Transactional
	public void create(Employee employee) {
		;
		employeeDAO.save(employee);
	}
}
