package ilan.models;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import ilan.enums.Gender;

public class ThirdPartyParticipantTest {

	@Test
	public void testCreation() {
		ThirdPartyParticipant test = new ThirdPartyParticipant("name","location");
		assertThat("Customer wasnt correctly instantiated",test.getName(),is("name"));
		assertThat("Customer wasnt correctly instantiated",test.getLocation(),is("location"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation() {
		new ThirdPartyParticipant(null,null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation2() {
		new ThirdPartyParticipant("name",null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation3() {
		new ThirdPartyParticipant(null,"location");
	}

}
