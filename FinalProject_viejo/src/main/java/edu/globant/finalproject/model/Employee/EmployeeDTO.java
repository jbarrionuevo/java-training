package edu.globant.finalproject.model.Employee;

import java.util.Date;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class EmployeeDTO{
	
	private String name;
	private String lastName;
	private Date birthDate;
	
	public EmployeeDTO(final String name){
		Validate.notBlank(name,"The name cannot be blank");
		
		this.name = name;
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
