package ilan.models;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class DeliverySellerTest {

	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation() {
		new DeliverySeller(null,null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation2() {
		new DeliverySeller("name",null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation3() {
		new DeliverySeller(null,"store");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation4() {
		new DeliverySeller("","");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation5() {
		new DeliverySeller("",null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation6() {
		new DeliverySeller(null,"");
	}
	
	@Test
	public void testCreation() {
		DeliverySeller test = new DeliverySeller("name","store");
		assertThat("CompleteSeller wasnt correctly instantiated",test.getName(),is("name"));
		assertThat("CompleteSeller wasnt correctly instantiated",test.getStore(),is("store"));
	}

}
