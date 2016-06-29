package edu.globant.testing.unit.exercise.sale;
import org.apache.commons.lang3.Validate;

public class Customer {

	private Long customerId;
	private String name;
	private String lastName;
	private int age;
	// true -- male
	// false -- woman
	private boolean gender;
	private String location;

	public Customer(Long customerId, String name, String lastName, int age, boolean gender, String location) {
		Validate.isTrue(customerId > 0, "The customer Id must be greater than zero");
        Validate.notBlank(name, "The name cannot be blank.");
        Validate.notBlank(lastName, "The name cannot be blank.");
        Validate.isTrue(age > 0, "The age must be greater than zero");
        Validate.notBlank(location, "The name cannot be blank.");
		this.customerId = customerId;
		this.setName(name);
		this.setLastName(lastName);
		this.setAge(age);
		this.setGender(gender);
		this.setLocation(location);
	}

	public Long getCustomerId() {
		return customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
        Validate.notBlank(name, "The name cannot be blank.");
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
        Validate.notBlank(lastName, "The name cannot be blank.");
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
        Validate.isTrue(age > 0, "The age must be greater than zero");
		this.age = age;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
        Validate.notBlank(location, "The name cannot be blank.");
		this.location = location;
	}

}
