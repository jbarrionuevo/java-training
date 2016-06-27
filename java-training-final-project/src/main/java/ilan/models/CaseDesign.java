package ilan.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.thymeleaf.util.Validate;

@Entity
public class CaseDesign implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	private String name;

	public CaseDesign(){}
	
	public CaseDesign(String name) {
		Validate.notEmpty(name, "Name cannot be blank");
		this.name = name;
	}

	@Override
	public String toString(){
		return String.format("Name: %s", this.getName());
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
