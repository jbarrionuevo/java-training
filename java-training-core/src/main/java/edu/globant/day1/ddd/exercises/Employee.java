package edu.globant.day1.ddd.exercises;

import java.util.Date;

import edu.globant.day1.oop.exercises.Employee.TypeOfEmployee;

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
