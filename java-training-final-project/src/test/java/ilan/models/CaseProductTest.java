package ilan.models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.hamcrest.CoreMatchers.*;

public class CaseProductTest {

	@Mock
	CaseDesign caseDesignMock;
	
	@Mock
	CaseDevice caseDeviceMock;
	
	@Mock
	Provider providerMock;
	
	@Before
    public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation() {
		new CaseProduct(null,caseDeviceMock,10.0,providerMock);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation2() {
		new CaseProduct(caseDesignMock,null,10.0,providerMock);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation3() {
		new CaseProduct(caseDesignMock,caseDeviceMock,null,providerMock);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation4() {
		new CaseProduct(caseDesignMock,caseDeviceMock,10.0,null);
	}
	
	@Test
	public void testCreation() {
		CaseProduct test = new CaseProduct(caseDesignMock,caseDeviceMock,10.0,providerMock);
		assertThat("Case Design wasnt correctly assigned",test.getDesign(),is(caseDesignMock));
		assertThat("Case Device wasnt correctly assigned",test.getDevice(),is(caseDeviceMock));
		assertThat("Provider wasnt correctly assigned",test.getProvider(),is(providerMock));
		assertThat("Price wasnt correctly assigned",test.getPrice(),is(10.0));
	}
	
	@Test
	public void testToString(){
		CaseProduct test = new CaseProduct(caseDesignMock,caseDeviceMock,10.0,providerMock);
		assertThat("To String method doesnt work as expected",test.toString(),equalTo("Design: "+caseDesignMock.getName()+
				", Device: "+caseDeviceMock.getName()+", Provider: "+providerMock.getName()+"("+providerMock.getLocation()+")"));
	}
	
	@Test
	public void testAddAlert(){
		CaseProduct test = new CaseProduct(caseDesignMock,caseDeviceMock,10.0,providerMock);
		int alertCount = test.getAlerts().size();
		test.addAlert(new OrderAlert(10, test));
		assertThat("Add alert doesnt work correctly",test.getAlerts().size(),is(alertCount+1));
	}
	
	@Test
	public void testRemoveAlert(){
		CaseProduct test = new CaseProduct(caseDesignMock,caseDeviceMock,10.0,providerMock);
		OrderAlert newAlert = new OrderAlert(10, test);
		test.addAlert(newAlert);
		int alertCount = test.getAlerts().size();
		test.removeAlert(newAlert);
		assertThat("Remove alert doesnt work correctly",test.getAlerts().size(),is(alertCount-1));
	}

}