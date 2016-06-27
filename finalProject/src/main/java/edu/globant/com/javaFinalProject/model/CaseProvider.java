package edu.globant.com.javaFinalProject.model;

import java.util.HashSet;
import java.util.Set;

public class CaseProvider {

	private int id;
	private String name;
	private Set<DeviceTypeEnum> deviceTypes = new HashSet<DeviceTypeEnum>();
	private Set<Order> orders = new HashSet<Order>();
	
	public CaseProvider(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<DeviceTypeEnum> getDeviceTypes() {
		return deviceTypes;
	}

	public void setDeviceTypes(Set<DeviceTypeEnum> deviceTypes) {
		this.deviceTypes = deviceTypes;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "CaseProvider [id=" + id + ", name=" + name + ", deviceTypes=" + deviceTypes + ", orders=" + orders
				+ "]";
	}	
	
}
