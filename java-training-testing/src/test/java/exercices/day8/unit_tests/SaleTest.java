package exercices.day8.unit_tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import exercices.day6.dependency_injection.models.Order;
import exercices.day6.dependency_injection.models.Sale;

import static org.hamcrest.CoreMatchers.*;

public class SaleTest {

	@Mock
	Order orderMock;
	
	@Before
    public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation() {
		new Sale(null);
	}
	
	@Test
	public void testCreation() {
		Sale sale = new Sale(orderMock);
		assertThat("Sale was wrongly instantiated", sale.getOrder(),is(orderMock));
	}
	
	

}
