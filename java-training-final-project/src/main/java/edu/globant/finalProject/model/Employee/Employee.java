package edu.globant.finalProject.model.Employee;

import java.util.Date;
import org.apache.commons.lang3.Validate;

public class Employee{
	private TypeOfEmployee typeOfEmployee;
	private String name;
	private String lastName;
	private Date birthDate;
	
	public Employee(final String name,TypeOfEmployee typeOfEmployee){
		Validate.notBlank(name,"The name cannot be blank");
		Validate.notNull(typeOfEmployee,"The type of employee cannot be null");
		
		this.name = name;
		this.typeOfEmployee = typeOfEmployee;
	}
	
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
