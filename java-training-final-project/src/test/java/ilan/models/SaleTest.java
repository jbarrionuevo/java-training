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
	Collection<Receipt> receipts;
	
	@Before
    public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation() {
		new Sale(null,null,10, SaleStatus.DRAFT);
	}
	
	@Test
	public void testCreation() {
		Sale sale = new Sale(orderMock,receipts,10, SaleStatus.DRAFT);
		assertThat("Sale was wrongly instantiated", sale.getOrder(),is(orderMock));
	}
	
	

}
