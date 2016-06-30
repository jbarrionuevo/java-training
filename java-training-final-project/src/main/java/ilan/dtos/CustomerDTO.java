package ilan.dtos;

import org.thymeleaf.util.Validate;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import ilan.enums.Gender;

public class CustomerDTO {
	private int age;
	private Gender gender;
	private String name,location;
	
	public CustomerDTO(){}
	
	@JsonCreator
	public CustomerDTO(@JsonProperty("name") String name,
			@JsonProperty("location")String location, 
			@JsonProperty("age")int age, 
			@JsonProperty("gender")Gender gender) {
		this.name=name;
		this.location=location;
		Validate.notNull(gender, "Gender cannot be blank");
		this.age = age;
		this.gender = gender;
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
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
