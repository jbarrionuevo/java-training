package edu.globant.testing;

import edu.globant.persistence.DAO.EmployeeDAO;
import edu.globant.persistence.DAO.EmployeeDAOImpl;
import edu.globant.persistence.DAO.hibernate.utils.HibernateUtils;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.globant.domain.Employee;
import edu.globant.utils.MySQLDataSourceProvider;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import edu.globant.service.employee.CreateEmployeeServiceImpl;
import edu.globant.service.employee.ListEmployeeServiceImpl;

public class EmployeeServiceIT {

	private CreateEmployeeServiceImpl createEmployeeService;
	private ListEmployeeServiceImpl listEmployeeService;
	private static final String configurationPath = "/edu/globant/config/database.properties";
	private static final String hibernateConfigXml = "/edu/globant/config/hibernate.cfg.xml";
	MySQLDataSourceProvider dsProvider = new MySQLDataSourceProvider();
	EmployeeDAO employeeDAO;
	ApplicationContext context;
	private Employee employee1;
	private Employee employee2;

	Session session;

	@Before
	public void setUp() {

		SessionFactory sessionFactory = HibernateUtils.buildSessionFactory(hibernateConfigXml,
				dsProvider.getMySQLDataSource(configurationPath));

		context = new ClassPathXmlApplicationContext("META-INF/beans.xml");

		session = sessionFactory.openSession();

		employeeDAO = new EmployeeDAOImpl(sessionFactory.openSession());

		createEmployeeService = new CreateEmployeeServiceImpl(employeeDAO);
		listEmployeeService = new ListEmployeeServiceImpl(employeeDAO);
		employee1 = new Employee("Juan", "seller");
		employee2 = new Employee("Jimena", "logistics");
	}

	@Test
	public void createAndList() {
		createEmployeeService.create(employee1);
		createEmployeeService.create(employee2);

		Employee employee1DB = listEmployeeService.findById(employee1.getId());
		Employee employee2DB = listEmployeeService.findById(employee2.getId());

		assertThat(employee1DB, equalTo(employee1));
		assertThat(employee1DB, not(equalTo(employee2)));
		assertThat(employee2, equalTo(employee2DB));
		assertThat(employee1DB, not(equalTo(employee2DB)));
	}

	@Test
	public void createAndListWithSpring() {

		BeanFactory factory = context;
		Employee employeeSpring1 = (Employee) factory.getBean("employee");
		employeeSpring1.setName("Pedro");
		employeeSpring1.setType("Logistics");

		createEmployeeService.create(employeeSpring1);

		Employee employee1DB = listEmployeeService.findById(employeeSpring1.getId());
		assertThat(employee1DB, equalTo(employeeSpring1));
	}
	
	@Test
	public void listAll() {
		Employee employee3 = new Employee("Ralph","Logistics");
		createEmployeeService.create(employee3);
		Employee employee3DB = listEmployeeService.findById(employee3.getId());
		List<Employee> employees = listEmployeeService.findAll();	
		assertThat(employees.isEmpty(), is(false));
		assertThat(employees.contains(employee1), is(false));
		assertThat(employees.contains(employee3), is(true));
		assertThat(employees.contains(employee3DB), is(true));
	}
}