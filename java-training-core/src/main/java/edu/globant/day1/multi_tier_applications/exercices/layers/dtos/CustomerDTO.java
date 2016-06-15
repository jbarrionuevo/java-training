package edu.globant.day1.multi_tier_applications.exercices.layers.dtos;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import edu.globant.day1.oop.exercices.enums.Gender;

public class CustomerDTO extends ThirdPartyParticipantDTO{
	@Min(18)
	private int age;
	@NotNull
	private Gender gender;
	
	public CustomerDTO(String name, String location, int age, Gender gender) {
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
