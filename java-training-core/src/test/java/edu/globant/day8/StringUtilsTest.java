package edu.globant.day7;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import edu.globant.day7.StringUtils;

public class StringUtilsTest {

	StringUtils stringUtils;

	@Before
	public void setup() {
		stringUtils = new StringUtils();
	}

	@Test
	public void emptyStringForNull() {
		assertThat(stringUtils.isEmpty(null), is(true));
	}
}
