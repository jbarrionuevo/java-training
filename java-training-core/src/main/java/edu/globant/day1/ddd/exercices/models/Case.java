package edu.globant.day1.ddd.exercices.models;

import java.util.Date;

public class Case {
	
	private CaseDesign design;
	private CaseDevice device;
	private double price;
	private Provider provider;
	
	public Case(CaseDesign design, CaseDevice device, Double price, Provider provider) {
		super();
		this.design = design;
		this.device = device;
		this.price=price;
		this.provider=provider;
	}
	
	@Override
	public String toString(){
		return String.format("Design: %s, Device: %s", 
				this.getDesign().getName(), this.getDevice().getName());
	}
	
	public CaseDesign getDesign() {
		return design;
	}
	public void setDesign(CaseDesign design) {
		this.design = design;
	}
	public CaseDevice getDevice() {
		return device;
	}
	public void setDevice(CaseDevice device) {
		this.device = device;
	}


	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	
	
}
