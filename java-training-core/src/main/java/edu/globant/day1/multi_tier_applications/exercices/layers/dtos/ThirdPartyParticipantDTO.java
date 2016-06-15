package edu.globant.day1.multi_tier_applications.exercices.layers.dtos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public abstract class ThirdPartyParticipantDTO {
	
	@NotNull
	@Size(min = 2, max = 20, message="The name must have between 2 and 20 characters")
	private String name;
	@NotNull
	private String location;
	
	public ThirdPartyParticipantDTO(String name,String location){
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
