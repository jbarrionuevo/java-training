package ilan.models;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CompleteSellerTest {

	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation() {
		new CompleteSeller(null,null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation2() {
		new CompleteSeller("name",null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation3() {
		new CompleteSeller(null,"store");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation4() {
		new CompleteSeller("","");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation5() {
		new CompleteSeller("",null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation6() {
		new CompleteSeller(null,"");
	}
	
	@Test
	public void testCreation() {
		CompleteSeller test = new CompleteSeller("name","store");
		assertThat("CompleteSeller wasnt correctly instantiated",test.getName(),is("name"));
		assertThat("CompleteSeller wasnt correctly instantiated",test.getStore(),is("store"));
	}

}
