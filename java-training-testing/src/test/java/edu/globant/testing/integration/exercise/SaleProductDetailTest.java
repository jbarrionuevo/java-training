package edu.globant.testing.integration.exercise;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import static org.junit.Assert.assertNull;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.globant.testing.unit.exercise.sale.CaseDesign;
import edu.globant.testing.unit.exercise.sale.CaseDevice;
import edu.globant.testing.unit.exercise.sale.ProductCase;
import edu.globant.testing.unit.exercise.sale.SaleProductDetail;

public class SaleProductDetailTest {

	private ProductCase product;
	private SaleProductDetail detail;

	@Before
	public void setUp() throws Exception {
		product = new ProductCase(123456L, "iPhone6 Case", CaseDevice.iPhone6, CaseDesign.RealCase, 19.65, 15);
	}

	@Test()
	public void createObjectWithValidArguments() {
		Double expectedPrice = 25 * 19.65;
		detail = new SaleProductDetail(product, 25);
		assertThat("Wrong price returned", detail.getTotalPrice(), equalTo(expectedPrice));
	}

	@Test(expected = IllegalArgumentException.class)
	public void createWithBlankArguments() {
		detail = new SaleProductDetail(product, 25);
		detail.setProductQuantity(-8);
	}

	@Test(expected = NullPointerException.class)
	public void createWithNullArgument() {
		detail = new SaleProductDetail(null, 25);
	}

	@After
	public void tearDown() {
		product = null;
		detail = null;
		assertNull(product);
		assertNull(detail);
	}
}
