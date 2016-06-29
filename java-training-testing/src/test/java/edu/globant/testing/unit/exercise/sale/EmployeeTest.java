package edu.globant.testing.unit.exercise.sale;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import edu.globant.testing.unit.exercise.sale.Employee;
import edu.globant.testing.unit.exercise.sale.EmployeeDepartment;

public class EmployeeTest {

	@Test()
	public void createObjectWithValidArguments() {
		Employee e;
		e = new Employee(12561L, "Pablo", "Pellecchia", 27, true, "Av. Cordoba", EmployeeDepartment.SALES);
		assertThat("Pablo", e.getName(), equalTo("Pablo"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void createWithBlankArguments() {
		Employee e;
		e = new Employee(12561L, StringUtils.EMPTY, "Pellecchia", 27, true, "Av. Cordoba", EmployeeDepartment.SALES);
	}
	
	@Test(expected = NullPointerException.class)
	public void createWithNullArgument() {
		Employee e;
		e = new Employee(null, "Pablo", "Pellecchia", 27, true, "Av. Cordoba", EmployeeDepartment.SALES);
	}
}
