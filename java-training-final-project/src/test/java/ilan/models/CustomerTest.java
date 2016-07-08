package ilan.models;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import ilan.enums.Gender;

public class CustomerTest {

	@Test
	public void testCreation() {
		Customer test = new Customer("name","location",23,Gender.M);
		assertThat("Customer wasnt correctly instantiated",test.getName(),is("name"));
		assertThat("Customer wasnt correctly instantiated",test.getLocation(),is("location"));
		assertThat("Customer wasnt correctly instantiated",test.getAge(),is(23));
		assertThat("Customer wasnt correctly instantiated",test.getGender(),is(Gender.M));
	}
	
	@Test
	public void testToString() {
		Customer test = new Customer("name","location",23,Gender.M);
		assertThat("To String method doesnt work as expected",
				test.toString(),equalTo(String.format("Name: %s, Location: %s, Age: %d, Gender: %s","name","location",23,Gender.M)));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation() {
		new Customer(null,null,0,null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation8() {
		new Customer("","",0,null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation2() {
		new Customer("name",null,0,null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation9() {
		new Customer("",null,0,null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation3() {
		new Customer("name","location",0,null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation4() {
		new Customer("name",null,0,Gender.M);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation10() {
		new Customer("",null,0,Gender.M);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation5() {
		new Customer(null,"location",0,null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation11() {
		new Customer(null,"",0,null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation6() {
		new Customer(null,"location",0,Gender.M);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation12() {
		new Customer(null,"",0,Gender.M);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation7() {
		new Customer(null,null,0,Gender.M);
	}
}
