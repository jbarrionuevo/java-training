package edu.globant.day1.multi_tier_applications.exercices.layers.dtos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public abstract class EmployeeDTO {
	@NotNull
	@Size(min = 2, max = 20, message="The name must have between 2 and 20 characters")
	private String name;
	
	public EmployeeDTO(){}
	
	public EmployeeDTO(String name){
		this.name=name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
