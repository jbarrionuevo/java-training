package edu.globant.testing.integration;

import persistence.DAO.EmployeeDAO;

import org.junit.Before;
import org.junit.Test;

import domain.Employee;
import edu.globant.utils.HibernateUtils;
import edu.globant.utils.MySQLDataSourceProvider;

import static org.hamcrest.CoreMatchers.*;

import static org.junit.Assert.assertThat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import service.employee.CreateEmployeeService;
import service.employee.ListEmployeeService;

public class EmployeeServiceIT {

	private CreateEmployeeService createEmployeeService;
	private ListEmployeeService listEmployeeService;
	private static final String configurationPath = "/edu/globant/config/database.properties";
	private static final String hibernateConfigXml = "/edu/globant/config/hibernate.cfg.xml";
	MySQLDataSourceProvider dsProvider = new MySQLDataSourceProvider();
	Employee employee1;
	Employee employee2;
	Session session;

	@Before
	public void setUp() {

		SessionFactory sessionFactory = HibernateUtils.buildSessionFactory(hibernateConfigXml,
				dsProvider.getMySQLDataSource(configurationPath));

		session = sessionFactory.openSession();

		EmployeeDAO<Employee> employeeDAO = new EmployeeDAO<Employee>(session);

		createEmployeeService = new CreateEmployeeService(employeeDAO);
		listEmployeeService = new ListEmployeeService(employeeDAO);
		employee1 = new Employee("Juan", "seller");
		employee2 = new Employee("Jimena", "logistics");
	}

	@Test
	public void createAndList() {
		createEmployeeService.create(employee1);
		createEmployeeService.create(employee2);
		System.out.println("************employee1.getId() = " + employee1.getId());
		System.out.println("************employee2.getId() = " + employee2.getId());

		Employee employee1DB = listEmployeeService.findById(employee1.getId());

		// assertThat(listEmployeeService.findById(employee1.getId()),
		// equalTo(employee1.getId()));
		// assertThat(employee1, equalTo(employee1DB));
		// assertThat(employee1DB, not(equalTo(employee2)));
	}

}
