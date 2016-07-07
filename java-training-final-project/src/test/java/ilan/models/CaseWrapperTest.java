package ilan.models;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CaseWrapperTest {
	
	@Mock
	Inventory inventoryMock;
	
	@Mock
	CaseProduct caseProductMock;
	
	@Before
    public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testFailedCreation1() {
		new CaseWrapper();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation2() {
		new CaseWrapper(null,null,null,null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation3() {
		new CaseWrapper(caseProductMock,null,null,null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation4() {
		new CaseWrapper(caseProductMock,0,null,null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation5() {
		new CaseWrapper(caseProductMock,0,100,null);
	}
	
	@Test
	public void testSuccesfullyCreation() {
		CaseWrapper test = new CaseWrapper(caseProductMock,0,100,inventoryMock);
		assertThat("CaseWrapper wasnt correctly assigned",test.getMyCase(),is(caseProductMock));
		assertThat("CaseWrapper wasnt correctly assigned",test.getInventory(),is(inventoryMock));
		assertThat("CaseWrapper wasnt correctly assigned",test.getMinimumStock(),is(0));
		assertThat("CaseWrapper wasnt correctly assigned",test.getCurrentStock(),is(100));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation7() {
		new CaseWrapper(null,0,null,null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation8() {
		new CaseWrapper(null,0,100,null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation9() {
		new CaseWrapper(null,0,100,inventoryMock);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation10() {
		new CaseWrapper(null,null,100,null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation11() {
		new CaseWrapper(null,null,100,inventoryMock);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation12() {
		new CaseWrapper(null,null,null,inventoryMock);
	}
	
}
