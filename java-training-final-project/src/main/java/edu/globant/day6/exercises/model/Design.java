package edu.globant.day6.exercises.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.commons.lang3.Validate;

@Entity
public class Design {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	public Design () {
		
	}

	public Design(String name) {
		Validate.notBlank(name, "Name cannot be blank");
		Validate.notNull(name, "Name cannot be null");
		this.name = name;
	}

	public String getName() {
		Validate.notBlank(name, "Name cannot be blank");
		Validate.notNull(name, "Name cannot be null");
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString(){
		return String.format(this.getName());
	}
}
