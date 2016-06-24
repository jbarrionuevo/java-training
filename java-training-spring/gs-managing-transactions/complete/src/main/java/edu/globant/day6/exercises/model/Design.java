package edu.globant.day6.exercises.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Design {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	public Design () {
		
	}

	public Design(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
