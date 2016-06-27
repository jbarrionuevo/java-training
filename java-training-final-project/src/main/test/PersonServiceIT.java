package edu.globant.testing.integration;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class EmployeeServiceIT {

    private EmployeeService service;

    @Before
    public void setUp() {
        service = new EmployeeService(new EmployeeDAO());
    }

    @Test
    public void storeAndRetrieve() {
        service.create("test");
        Employee person = service.findBy("test");

        assertThat("The person just created and retrieved is null", employee, notNullValue());
        assertThat("Wrong person just created and retrieved", employee.getName(), equalTo("test"));
    }

}
