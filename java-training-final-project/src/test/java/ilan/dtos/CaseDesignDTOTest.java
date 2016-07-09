package ilan.dtos;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import ilan.models.CaseDesign;

public class CaseDesignDTOTest {

	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation() {
		new CaseDesignDTO(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation2() {
		new CaseDesignDTO("");
	}
	
	@Test
	public void testCreation() {
		CaseDesignDTO test = new CaseDesignDTO("Test");
		assertThat("Case Design wasnt correctly instantiated",test.getName(),is("Test"));
	}

}
