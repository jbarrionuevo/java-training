package edu.globant.day1.multi_tier_applications.exercices.layers.dtos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CaseDeviceDTO {
	
	@NotNull
	@Size(min = 6, max = 20, message="Case Device name must have between 6 and 20 characters")
	private String name;

	
	public CaseDeviceDTO(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
