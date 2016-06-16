package edu.globant.day1.oop.exercises.model.employee;

public abstract class Employee {

	private String name;
	private String lastName;
	private int age;
	//true -- male
	//false -- woman
	private boolean gender;
	private String adress;
	
	public Employee(String name, String lastName, int age, boolean gender, String adress) {
		this.setName(name);
		this.setLastName(lastName);
		this.setAge(age);
		this.setGender(gender);
		this.setAdress(adress);
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
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}
	
}
