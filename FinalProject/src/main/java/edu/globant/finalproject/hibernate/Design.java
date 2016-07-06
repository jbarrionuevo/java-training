package edu.globant.finalproject.hibernate;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "design")
public class Design extends BaseEntity implements Serializable{

	
	private Design(){}
	
	public Design(String colour, double length, double height){
		this.colour = colour;
		this.lenght = length;
		this.height = height;
	}
	
	@Column(name = "colour")
	private String colour;
	
	@Column(name = "lenght")
	private double lenght;
	
	@Column(name = "height")
	private double height;

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
