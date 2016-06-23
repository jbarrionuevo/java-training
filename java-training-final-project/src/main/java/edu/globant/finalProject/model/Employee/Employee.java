package edu.globant.finalProject.model.Employee;

import java.util.Date;

public abstract class Employee{
	private TypeOfEmployee typeOfEmployee;
	private String name;
	private String lastName;
	private Date birthDate;
	
	public TypeOfEmployee getTypeOfEmployee() {
		return typeOfEmployee;
	}
	public void setTypeOfEmployee(TypeOfEmployee typeOfEmployee) {
		this.typeOfEmployee = typeOfEmployee;
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
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}	
}
