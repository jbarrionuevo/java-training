package exercices.day6.dependency_injection.models;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CaseDeviceTest {
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation() {
		new CaseDevice(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation2() {
		new CaseDevice("");
	}
	
	@Test
	public void testCreation() {
		CaseDevice test = new CaseDevice("Test");
		assertThat("Case Device wasnt correctly instantiated",test.getName(),is("Test"));
	}
	
	@Test
	public void testToString() {
		CaseDevice test = new CaseDevice("Test");
		assertThat("To String method doesnt work as expected",
				test.toString(),equalTo("Name: "+test.getName()));
	}
}
