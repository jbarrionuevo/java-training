package edu.globant.testing.integration;

import junit.framework.Assert;
import persistence.DAO.EmployeeDAO;

import org.junit.Before;
import org.junit.Test;

import domain.Employee;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import org.hibernate.Session;

import service.employee.CreateEmployeeService;

public class EmployeeServiceIT {

	private CreateEmployeeService service;
	private Session session;

	@Before
	public void setUp() {
		service = new CreateEmployeeService(new EmployeeDAO(session));
	}

	@Test
	public void createAndRetrieve() {
		service.create("Juan", "seller");
		//Employee employee = service.findByID("Juan");

		//assertThat("The person just created and retrieved is null", employee, notNullValue());
		//assertThat("Wrong person just created and retrieved", employee.getName(), equalTo("test"));
	}

}
