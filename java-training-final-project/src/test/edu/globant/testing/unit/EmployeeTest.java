package edu.globant.testing.unit;

import domain.Employee;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class EmployeeTest {

    @Test(expected = NullPointerException.class)
    public void createWithNullName() {
        new Employee(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createWithBlankName() {
        new Employee(StringUtils.EMPTY, StringUtils.EMPTY);
    }

    @Test
    public void createWithValidNameAndType() {
        Employee person = new Employee("Juan", "Seller");

        assertThat("The name of the person just created does not match",
                person.getName(), equalTo("Juan"));
        assertThat("The type of the person just created does not match",
        		person.getType(), equalTo("Seller"));
        
    }

    @Test(expected = NullPointerException.class)
    public void setTypeWithNullMessage() {
        Employee person = new Employee("Pedro", "Logistics");
        person.setType(null);
    }

    @Test(expected = NullPointerException.class)
    public void setNameWithNullMessage() {
        Employee person = new Employee("Pedro", "Logistics");
        person.setName(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void setNameWithEmptyMessage() {
        Employee person = new Employee("", "Seller");
        person.setType(StringUtils.EMPTY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setTypeWithEmptyMessage() {
        Employee person = new Employee("Pedro", "");
        person.setType(StringUtils.EMPTY);
    }
    
    @Test
    public void getNameWithValidMessage() {
        Employee employee = new Employee("Carlos", "Seller");

        assertThat("Wrong name message",
        		employee.getName(), equalTo("Carlos"));
    }
    
    @Test
    public void getTypeWithValidMessage() {
        Employee employee = new Employee("Carlos", "Seller");

        assertThat("Wrong name message",
        		employee.getType(), equalTo("Seller"));
    }

}
