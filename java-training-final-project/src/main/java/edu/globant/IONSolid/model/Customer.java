package edu.globant.IONSolid.model;

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
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
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
		this.location = location;
	}

}
