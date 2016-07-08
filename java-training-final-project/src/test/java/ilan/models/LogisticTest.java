package ilan.models;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ilan.enums.Gender;

public class LogisticTest {
	
	@Mock
	Inventory inventoryMock;
	
	@Before
    public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testCreation() {
		Logistic test = new Logistic("name",inventoryMock);
		assertThat("Customer wasnt correctly instantiated",test.getName(),is("name"));
		assertThat("Customer wasnt correctly instantiated",test.getInventory(),is(inventoryMock));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation1() {
		new Logistic("",null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation2() {
		new Logistic(null,null);
	}
	

}
