package edu.globant.testing.unit.exercise.sale;

import org.apache.commons.lang3.Validate;

public class Employee {

	private Long employeeId;
	private String name;
	private String lastName;
	private int age;
	//true -- male
	//false -- woman
	private boolean gender;
	private String address;
	private EmployeeDepartment role;
	
	public Employee(Long id, String name, String lastName, int age, boolean gender, String adress, EmployeeDepartment role) {
		Validate.notNull(id, "Id can not be null");		
		this.employeeId = id;
		this.setName(name);
		this.setLastName(lastName);
		this.setAge(age);
		this.setGender(gender);
		this.setAdress(adress);
		Validate.isInstanceOf(EmployeeDepartment.class, role, "The role is not allow");
		this.role = role;
	}
	
	public Long getEmployeeId() {
		return this.employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
        Validate.notBlank(name, "The name cannot be blank.");
		this.name = name;
	}

	public String getLastName() {
        Validate.notBlank(name, "The lastName cannot be blank.");
		return lastName;
	}

	public void setLastName(String lastName) {
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

	public String getAdress() {
		return address;
	}

	public void setAdress(String address) {
        Validate.notBlank(address, "The address cannot be blank.");
		this.address = address;
	}
	
	public EmployeeDepartment getRole() {
		return this.role;
	}
}
