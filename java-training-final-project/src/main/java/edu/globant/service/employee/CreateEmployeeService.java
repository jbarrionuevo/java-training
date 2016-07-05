package edu.globant.service.employee;

import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import edu.globant.domain.Employee;
import edu.globant.persistence.DAO.EmployeeDAO;
import edu.globant.service.ServiceImpl;
import edu.globant.service.spring.DependencyInjectorSpring;

public class CreateEmployeeService extends ServiceImpl implements DependencyInjectorSpring{

	private EmployeeDAO employeeDAO;
	
	public CreateEmployeeService(Session session) {
		super(session);
		this.employeeDAO = new EmployeeDAO(session);
	}

	@Transactional	
	public void create(Employee employee) {;
		employeeDAO.save(employee);
	}
}
