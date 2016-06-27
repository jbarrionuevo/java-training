package ilan.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.thymeleaf.util.Validate;

@Entity
public class CaseDevice implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	public CaseDevice(){}
	
	@Override
	public String toString(){
		return String.format("Name: %s", this.getName());
	}
	
	public CaseDevice(String name) {
		Validate.notEmpty(name, "Name cannot be blank");
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
