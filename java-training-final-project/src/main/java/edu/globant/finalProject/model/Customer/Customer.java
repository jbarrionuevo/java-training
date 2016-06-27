package edu.globant.finalProject.model.Customer;

import org.apache.commons.lang3.Validate;

public class Customer {
	private String name;
	private int age;
	private char gender;
	private String location;
	
	public Customer(String name, int age, char gender, String location){
		Validate.notBlank(name,"The name cannot be empty");
		Validate.notNull(age,"The age cannot be empty");
		Validate.notNull(gender,"The gender cannot be empty");
		Validate.notBlank(location,"The location cannot be empty");
		
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.location = location;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
