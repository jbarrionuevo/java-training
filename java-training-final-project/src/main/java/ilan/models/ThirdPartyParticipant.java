package ilan.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.thymeleaf.util.Validate;

@Entity
public class ThirdPartyParticipant implements Serializable{
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name,location;
	
	public ThirdPartyParticipant(){}
	
	public ThirdPartyParticipant(String name,String location){
		Validate.notEmpty(name, "Name cannot be empty");
		Validate.notEmpty(location, "Location cannot be empty");
		this.name=name;
		this.location=location;
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
}
