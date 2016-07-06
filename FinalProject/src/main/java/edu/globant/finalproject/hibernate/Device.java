package edu.globant.finalproject.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "device")
public class Device extends BaseEntity{
	
	private Device(){}
	
	public Device(String brand, String model){
		this.brand = brand;
		this.model = model;
	}
	
	@Column(name = "brand")
	private String brand;
	
	@Column(name = "model")
	private String model;

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
