package edu.globant.day1.ddd.exercices.models;

import edu.globant.day1.oop.exercices.enums.Gender;

public class Customer extends ThirdPartyParticipant{
	private int age;
	private Gender gender;
	
	public Customer(String name, String location, int age, Gender gender) {
		super(name,location);
		this.age = age;
		this.gender = gender;
	}
	
	@Override
	public String toString(){
		return String.format("Name: %s, Location: %s, Age: %d, Gender: %s", 
				this.getName(), this.getLocation(), this.getAge(), this.getGender());
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	
}
