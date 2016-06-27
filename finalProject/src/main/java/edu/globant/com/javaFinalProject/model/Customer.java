package edu.globant.com.javaFinalProject.model;

import java.util.HashSet;
import java.util.Set;

public class Customer {

	private int id;
	private String name;
	private int age;
	private String gender = CustomerGenderEnum.MALE.getCustomerGender();
	private String location;
	private Set<Sale> receipts = new HashSet<Sale>();
	
	public Customer(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Set<Sale> getReceipts() {
		return receipts;
	}

	public void setReceipts(Set<Sale> receipts) {
		this.receipts = receipts;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", location="
				+ location + ", receipts=" + receipts + "]";
	}
	
	
	
}
