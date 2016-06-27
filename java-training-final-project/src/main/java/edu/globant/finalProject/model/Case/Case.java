package edu.globant.finalProject.model.Case;

import java.util.ArrayList;
import java.util.TreeSet;

import org.apache.commons.lang3.Validate;

import edu.globant.finalProject.model.Provider.Provider;

public class Case {

	private int id;
	private String name;
	private TreeSet<Provider> providers;
	private ArrayList<Device> devices;
	private Design design;
	protected double price;
	protected int MINIMUM_QUANTITY;

	public Case(int id, String name, TreeSet<Provider> providers,ArrayList<Device> devices, Design design, double price, int minimum) {
		
		Validate.notNull(id,"The id cannot be null");
		Validate.notBlank(name,"The name cannot be blank");
		Validate.notEmpty(providers,"It must have at least one provider");
		Validate.notEmpty(devices,"It must have at least one device");
		Validate.notNull(design,"The design cannot be null");
		Validate.notNull(price,"The price cannot be null");
		Validate.notNull(minimum,"The minimum quantity cannot be null");
		
		this.id = id;
		this.name = name;
		this.MINIMUM_QUANTITY = minimum;
		this.providers = providers;
		this.devices = devices;
		this.design = design;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public TreeSet<Provider> getProviders() {
		return providers;
	}

	public void setProviders(TreeSet<Provider> providers) {
		this.providers = providers;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getMINIMUM_QUANTITY() {
		return MINIMUM_QUANTITY;
	}

	public void setMINIMUM_QUANTITY(int mINIMUM_QUANTITY) {
		MINIMUM_QUANTITY = mINIMUM_QUANTITY;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
