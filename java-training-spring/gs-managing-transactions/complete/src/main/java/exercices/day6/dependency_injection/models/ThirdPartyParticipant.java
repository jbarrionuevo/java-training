package exercices.day6.dependency_injection.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ThirdPartyParticipant implements Serializable{
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name,location;
	
	public ThirdPartyParticipant(){}
	
	public ThirdPartyParticipant(String name,String location){
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
