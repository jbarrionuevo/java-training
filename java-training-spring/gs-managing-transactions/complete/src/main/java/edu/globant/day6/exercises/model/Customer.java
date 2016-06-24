package edu.globant.day6.exercises.model;

public class Customer {
	
	private String name;
	private int age;
	private char gender;
	private String location;

	public Customer(String name, int age, char gender, String location) {
		super();
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
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
