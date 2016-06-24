package exercices.day8.unit_tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import exercices.day6.dependency_injection.models.Provider;

public class ProviderTest {

	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation() {
		new Provider(null,null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation2() {
		new Provider("",null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation3() {
		new Provider(null,"");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation4() {
		new Provider("test",null);
	}
	
	@Test
	public void testCreation() {
		Provider test = new Provider("testName","testLocation");
		assertThat("Provider wasnt correctly assigned",test.getName(),is("testName"));
		assertThat("Provider wasnt correctly assigned",test.getLocation(),is("testLocation"));
	}
	
	
	@Test
	public void testToString(){
		Provider test = new Provider("testName","testLocation");
		assertThat("To String method doesnt work as expected",test.toString(),equalTo(
				"Name: "+test.getName()+". Location: "+test.getLocation()));
	}
	

}
