package edu.globant.testing.integration;

import edu.globant.persistence.DAO.EmployeeDAO;
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

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import edu.globant.service.employee.CreateEmployeeService;
import edu.globant.service.employee.EmployeeService;
import edu.globant.service.employee.ListEmployeeService;

public class EmployeeServiceFacadeIT {

	private EmployeeService employeeService;

	private static final String configurationPath = "/edu/globant/config/database.properties";
	private static final String hibernateConfigXml = "/edu/globant/config/hibernate.cfg.xml";
	MySQLDataSourceProvider dsProvider = new MySQLDataSourceProvider();
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

		employeeService = new EmployeeService(session);

		employee1 = new Employee("Juan", "seller");
		employee2 = new Employee("Jimena", "logistics");
	}

	@Test
	public void createAndList() {
		employeeService.addEmployee(employee1);
		employeeService.addEmployee(employee2);

		Employee employee1DB = (Employee) employeeService.findById(employee1.getId());
		Employee employee2DB = (Employee) employeeService.findById(employee2.getId());

		//assertThat(employee1DB, equalTo(employee1));
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

		employeeService.addEmployee(employeeSpring1);

		Employee employee1DB = (Employee) employeeService.findById(employeeSpring1.getId());
		assertThat(employee1DB, equalTo(employeeSpring1));
	}
}
