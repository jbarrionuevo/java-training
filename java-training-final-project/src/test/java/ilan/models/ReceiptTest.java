package ilan.models;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ilan.enums.Gender;

public class ReceiptTest {

	@Mock
	Customer customerMock;
	
	@Before
    public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testCreation() {
		Receipt test = new Receipt("store",new Date(),customerMock);
		assertThat("Receipt wasnt correctly instantiated",test.getStoreName(),is("store"));
		assertThat("Receipt wasnt correctly instantiated",test.getDateOfSale(),is(notNullValue()));
		assertThat("Receipt wasnt correctly instantiated",test.getCustomer(),is(customerMock));
	}

	@Test
	public void testToString() {
		Receipt test =  new Receipt("store",new Date(),customerMock);
		assertThat("To String method doesnt work as expected",
				test.toString(),equalTo(String.format("Receipt: Store name: %s; Customer: [%s];"
						+ "Date: %s", "store", customerMock, (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")).format(test.getDateOfSale()))));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation() {
		new Receipt(null,new Date(),null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation2() {
		new Receipt("store",new Date(),null);
	}
	
}
