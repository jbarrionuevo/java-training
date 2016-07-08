package ilan.models;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class StoreSellerTest {

	@Test
	public void testCreation() {
		StoreSeller test = new StoreSeller("name","store");
		assertThat("CompleteSeller wasnt correctly instantiated",test.getName(),is("name"));
		assertThat("CompleteSeller wasnt correctly instantiated",test.getStore(),is("store"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation() {
		new StoreSeller(null,null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation2() {
		new StoreSeller("name",null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation3() {
		new StoreSeller(null,"store");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation4() {
		new StoreSeller("","");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation5() {
		new StoreSeller("",null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation6() {
		new StoreSeller(null,"");
	}

}
