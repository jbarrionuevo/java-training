package edu.globant.finalProject.model.Case;

import java.util.ArrayList;
import java.util.TreeSet;

import org.apache.commons.lang3.Validate;

import edu.globant.finalProject.hibernate.BaseEntity;
import edu.globant.finalProject.model.Provider.Provider;

public class Case extends BaseEntity{
	
	private String name;
	//TODO: debería autoasignarse
	private Provider provider;
	private ArrayList<Device> devices;
	private Design design;
	protected double price;

	public Case(String name,ArrayList<Device> devices, Design design, double price) {
		
		Validate.notBlank(name,"The name cannot be blank");
		Validate.notEmpty(devices,"It must have at least one device");
		Validate.notNull(design,"The design cannot be null");
		Validate.notNull(price,"The price cannot be null");
		
		this.name = name;
		this.devices = devices;
		this.design = design;
		this.price = price;
	}

	public Design getDesign() {
		return design;
	}

	public void setDesign(Design design) {
		this.design = design;
	}

	public ArrayList<Device> getDevices() {
		return devices;
	}

	public void setDevices(ArrayList<Device> devices) {
		this.devices = devices;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
