package edu.globant.testing.integration;

import junit.framework.Assert;
import persistence.DAO.EmployeeDAO;

import org.junit.Before;
import org.junit.Test;

import domain.Employee;
import edu.globant.utils.HibernateUtils;
import edu.globant.utils.MySQLDataSourceProvider;

import static org.hamcrest.CoreMatchers.*;

import static org.junit.Assert.assertThat;

import java.util.Scanner;

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

	@Before
	public void setUp() {
		SessionFactory sessionFactory = HibernateUtils.buildSessionFactory(hibernateConfigXml,
				dsProvider.getMySQLDataSource(configurationPath));

		createEmployeeService = new CreateEmployeeService(new EmployeeDAO(sessionFactory.getCurrentSession()));
		listEmployeeService = new ListEmployeeService(new EmployeeDAO(sessionFactory.getCurrentSession()));

	}
	
//	@Test
//	public void createAndList() {
//		
//		createEmployeeService.create("Juan", "seller");
//		assertThat(listEmployeeService.findById(), allOf(
//				is(notNullValue()),
//				equalTo(new Emlployee("Juan", "seller"))
//			));
//	}

	@Test
	public void shouldFindSomething() {
		
	}
}
