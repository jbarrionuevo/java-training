package edu.globant.testing.unit;

import domain.Employee;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import org.mockito.Mockito;

public class EmployeeTest {

	Employee employeeMock;

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

		assertThat("The name of the person just created does not match", person.getName(), equalTo("Juan"));
		assertThat("The type of the person just created does not match", person.getType(), equalTo("Seller"));

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
		Employee employee = new Employee("Pedro", "");
		employee.setType(StringUtils.EMPTY);
	}

	@Test
	public void getNameWithValidMessage() {
		Employee employee = new Employee("Carlos", "Seller");

		assertThat("Wrong name message", employee.getName(), equalTo("Carlos"));
	}

	@Test
	public void getTypeWithValidMessage() {
		Employee employee = new Employee("Carlos", "Seller");

		assertThat("Wrong name message", employee.getType(), equalTo("Seller"));
	}

	@Test
	public void createWithValidNameAndTypeMock() {
		employeeMock = Mockito.mock(Employee.class);

		Mockito.when(employeeMock.getId()).thenReturn(24L);
		Mockito.when(employeeMock.getName()).thenReturn("Joe");
		Mockito.when(employeeMock.getType()).thenReturn("Seller");

		assertThat("The name of the person just created does not match", employeeMock.getName(), equalTo("Joe"));
		assertThat("The type of the person just created does not match", employeeMock.getType(), equalTo("Seller"));
		assertThat("The type of the person just created does not match", employeeMock.getId(), equalTo(24L));
		assertThat("The name of the person just created does not match", employeeMock.getName(), not(equalTo("peter")));
		assertThat("The type of the person just created does not match", employeeMock.getType(),
				not(equalTo("logistics")));
		assertThat("The type of the person just created does not match", employeeMock.getId(), not(equalTo(22L)));

	}
}
