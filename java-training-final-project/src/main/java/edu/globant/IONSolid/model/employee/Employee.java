package edu.globant.IONSolid.model.employee;

public abstract class Employee {

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
		this.setName(name);
		this.setLastName(lastName);
		this.setAge(age);
		this.setGender(gender);
		this.setAdress(adress);
		this.role = role;
	}
	
	public Long getEmployeeId() {
		return this.employeeId;
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

	public String getAdress() {
		return address;
	}

	public void setAdress(String adress) {
		this.address = adress;
	}
	
	public EmployeeDepartment getRole() {
		return this.role;
	}
	
}
