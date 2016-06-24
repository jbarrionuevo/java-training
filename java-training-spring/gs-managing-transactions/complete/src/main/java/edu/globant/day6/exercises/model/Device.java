package edu.globant.day6.exercises.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Device {
	@Id
	@GeneratedValue
	private Long id;
	private String name;

	public Device() {
	}
	
	public Device(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
