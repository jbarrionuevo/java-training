package edu.globant.testing.unit.exercise.sale;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class ProductCaseTest {

	ProductCase p;

	@Test()
	public void createObjectWithValidArguments() {
		p = new ProductCase(123456L, "iPhone6 Case", CaseDevice.iPhone6, CaseDesign.RealCase, 19.65, 15);
		assertThat("iPhone6 Case", p.getName(), equalTo("iPhone6 Case"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void createWithBlankArguments() {
		p = new ProductCase(123456L, StringUtils.EMPTY, CaseDevice.iPhone6, CaseDesign.RealCase, -953.36, 15);
	}

	@Test(expected = NullPointerException.class)
	public void createWithNullArgument() {
		p = new ProductCase(null, "iPhone6 Case", CaseDevice.iPhone6, CaseDesign.RealCase, 19.65, 15);
	}
}
