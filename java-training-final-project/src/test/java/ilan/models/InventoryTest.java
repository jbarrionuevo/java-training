package ilan.models;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class InventoryTest {

	@Mock
	CaseProduct caseMock;
	
	@Before
    public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testCreation() {
		Inventory test = new Inventory();
		assertThat("Inventory wasnt correctly instantiated",test.getStock(),is(notNullValue()));
	}
	
	@Test
	public void testAddCase() {
		Inventory test = new Inventory();
		int count = test.getStock().size();
		test.addCase(caseMock, 100, 100);
		assertThat("Inventory add case method not working properly",test.getStock().size(),is(count+1));
	}

}
