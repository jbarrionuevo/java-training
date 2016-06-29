package edu.globant.testing.unit.exercise.sale;

import org.junit.Test;

import edu.globant.testing.unit.exercise.sale.Customer;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import org.apache.commons.lang3.StringUtils;

public class CustomerTest {

	@Test()
	public void createObjectWithValidArguments() {
		Customer c;
		c = new Customer(12561L, "Pablo", "Pellecchia", 27, true, "Argentina");
		assertThat("Pablo", c.getName(), equalTo("Pablo"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void createWithBlankArguments() {
		Customer c;
		c = new Customer(12561L, StringUtils.EMPTY, StringUtils.EMPTY, 27, true, "Argentina");
	}
	
	@Test(expected = NullPointerException.class)
	public void createWithNullArgument() {
		Customer c;
		c = new Customer(null, "Pablo", "Pellecchia", 27, true, "Argentina");
	}
}
