package exercices.day6.dependency_injection.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public abstract class ThirdPartyParticipant {
	
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
