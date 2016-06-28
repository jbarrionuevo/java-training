package edu.globant.day7.exercises.unit;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import edu.globant.day6.exercises.model.Case;
import edu.globant.day6.exercises.model.Design;
import edu.globant.day6.exercises.model.Device;

public class CaseTest {

	@Test(expected = NullPointerException.class)
	public void setDesignWithNull() {
		new Design(null);
	}

	@Test(expected = NullPointerException.class)
	public void setDeviceWithNull() {
		new Device(null);
	}

	@Test
	public void setDesign() {
		Design des = new Design("adesign");
		assertThat(des.getName(), equalTo("adesign"));
	}

	@Test
	public void setDevice() {
		Device dev = new Device("adevice");
		assertThat(dev.getName(), equalTo("adevice"));
	}

	@Test(expected = NullPointerException.class)
	public void testCaseWithNulls() {
		new Case(null, null, 10.0, 50);

	}

	@Test(expected = NullPointerException.class)
	public void testCaseWithAllNulls() {
		new Case(null, null, null, 0);

	}

	@Test
	public void testCaseWithData() {
		Case c = new Case(new Design("adesign"), new Device("adevice"), 10.0, 0);
		assertThat(c.getDesign().toString(), equalTo("adesign"));
		assertThat(c.getDevice().toString(), equalTo("adevice"));
		assertThat(c.getPrice(), equalTo(10.0));
		assertThat(c.getStock(), equalTo(0));
	}

}
