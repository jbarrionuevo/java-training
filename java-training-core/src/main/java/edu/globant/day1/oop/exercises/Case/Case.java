package edu.globant.day1.oop.exercises.Case;

import java.util.ArrayList;
import java.util.TreeSet;

import edu.globant.day1.oop.exercises.Provider.Provider;

public abstract class Case{
	
	private TreeSet<Provider> providers;
	private ArrayList<Device> devices;
	private Design design;
	protected double price;
	protected int quantity;
	protected int MINIMUM_QUANTITY;
	
	public Case(){
		
	}
	
	public Case(TreeSet<Provider> providers,ArrayList<Device> devices ,Design design,double price,int quantity, int minimum){
		this.MINIMUM_QUANTITY = minimum;
		this.providers = providers;
		this.devices = devices;
		this.design = design;
		this.price = price;
		this.quantity = quantity;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getMINIMUM_QUANTITY() {
		return MINIMUM_QUANTITY;
	}
	public void setMINIMUM_QUANTITY(int mINIMUM_QUANTITY) {
		MINIMUM_QUANTITY = mINIMUM_QUANTITY;
	}
	
	public boolean hasLowStock() {
		return getQuantity() <= getMINIMUM_QUANTITY();
	}
	
	public void decreaseInventory() {
		this.quantity --;
	}
	
	
}
