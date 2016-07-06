package edu.globant.finalproject.model.Case;

import org.apache.commons.lang3.Validate;

public class DesignDTO {
	private String colour;
	private double lenght;
	private double height;
	
	public DesignDTO(String colour, double length, double height){
		Validate.notBlank(colour,"the colour cannot be blank");
		Validate.notBlank(colour,"the length cannot be blank");
		Validate.notBlank(colour,"the heigth cannot be blank");
		
		this.colour = colour;
		this.lenght = length;
		this.height = height;
	}
	
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public double getLenght() {
		return lenght;
	}
	public void setLenght(double lenght) {
		this.lenght = lenght;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
	
}
