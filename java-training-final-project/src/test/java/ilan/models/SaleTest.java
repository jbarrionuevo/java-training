package ilan.models;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ilan.enums.SaleStatus;

import static org.hamcrest.CoreMatchers.*;

public class SaleTest {

	@Mock
	CaseOrder orderMock;
	@Mock
	Collection<Receipt> receiptsMock;
	
	@Before
    public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testCreation() {
		Sale sale = new Sale(orderMock,receiptsMock,10, SaleStatus.DRAFT);
		assertThat("Sale was wrongly instantiated", sale.getOrder(),is(orderMock));
		assertThat("Sale was wrongly instantiated", sale.getReceipts(),is(receiptsMock));
		assertThat("Sale was wrongly instantiated", sale.getStatus(),is(SaleStatus.DRAFT));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation() {
		new Sale(null,null,10, null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation2() {
		new Sale(orderMock,null,10, null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation3() {
		new Sale(null,receiptsMock,10, null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation4() {
		new Sale(null,null,10, SaleStatus.DRAFT);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation5() {
		new Sale(orderMock,receiptsMock,10, null);
	}
		
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation7() {
		new Sale(null,receiptsMock,10, SaleStatus.DRAFT);
	}
	
	

}
