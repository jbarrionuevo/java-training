package edu.globant.testing;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.mockito.Mockito;

import edu.globant.domain.Employee;
import edu.globant.domain.Sell;
import edu.globant.domain.SellStatus;
import edu.globant.domain.Store;

public class SellTest {
	
	Employee sellerMock;
	SellStatus sellStatusMock;
	Store storeMock;
	
	@Test(expected = NullPointerException.class)
	public void createWithNullStore() {
		sellerMock = Mockito.mock(Employee.class);
		new Sell(null, sellerMock);
	}
	
	@Test(expected = NullPointerException.class)
	public void createWithNullSeller() {
		storeMock = Mockito.mock(Store.class);
		new Sell(storeMock, null);
	}
	
}
