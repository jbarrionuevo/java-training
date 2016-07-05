package edu.globant.service.facade;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import edu.globant.domain.Employee;
import edu.globant.persistence.DAO.EmployeeDAO;
import edu.globant.persistence.DAO.hibernate.utils.HibernateFactory;
import edu.globant.service.employee.CreateEmployeeService;
import edu.globant.service.employee.ListEmployeeService;
import edu.globant.service.spring.DependencyInjectorSpring;

public class EmployeeServiceFacade implements DependencyInjectorSpring, HibernateFactory {

	private CreateEmployeeService createEmployeeService;
	private ListEmployeeService listEmployeeService;
	private EmployeeDAO employeeDAO;

	public EmployeeServiceFacade(Session session) {
		//Session session = this.getHibernateSessionFactory().openSession();
		createEmployeeService = new CreateEmployeeService(session);
		listEmployeeService = new ListEmployeeService(session);
		//employeeDAO = new EmployeeDAO(this.getHibernateSessionFactory().openSession());
		//createEmployeeService = new CreateEmployeeService(employeeDAO);
		//listEmployeeService = new ListEmployeeService(employeeDAO);
	}

	public void addEmployee(Employee employee) {
		createEmployeeService.create(employee);
	}

	public List<String> ListAllEmployees() {
		return listEmployeeService.findAllEmployees();
	}
}
