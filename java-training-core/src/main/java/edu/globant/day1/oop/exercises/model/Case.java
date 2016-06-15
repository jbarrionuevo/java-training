package edu.globant.day1.oop.exercises.model;

public class Case {

	private Design design;
	private Device devices;
	private double price;
	private int stock;

	public Design getDesign() {
		return design;
	}

	public void setDesign(Design design) {
		this.design = design;
	}

	public Device getDevice() {
		return devices;
	}

	public void setDevice(Device device) {
		this.devices = device;
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
