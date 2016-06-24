package edu.globant.day6.exercises.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Case implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	private Design design;
	@ManyToOne
	private Device device;
	private double price;
	private int stock;

	public Case() {
	}

	public Case(Design design, Device device, Double price, int stock) {
		this.design = design;
		this.device = device;
		this.price = price;
		this.stock = stock;
	}

	public Design getDesign() {
		return design;
	}

	public void setDesign(Design design) {
		this.design = design;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
