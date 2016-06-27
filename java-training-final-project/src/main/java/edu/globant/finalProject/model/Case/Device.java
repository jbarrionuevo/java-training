package edu.globant.finalProject.model.Case;

import org.apache.commons.lang3.Validate;

public class Device {
	private String brand;
	private String model;
	
	public Device(String brand, String model){
		Validate.notBlank(brand);
		Validate.notBlank(model);
		
		this.brand = brand;
		this.model = model;
	}
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	
}
