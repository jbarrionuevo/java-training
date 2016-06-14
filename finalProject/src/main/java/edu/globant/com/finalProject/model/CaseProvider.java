package edu.globant.com.finalProject.model;

import java.util.HashSet;
import java.util.Set;

public class CaseProvider {

	private int id;
	private String name;
	private Set<DeviceTypeEnum> deviceTypes = new HashSet<DeviceTypeEnum>();
	
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

	@Override
	public String toString() {
		return "CaseProvider [id=" + id + ", name=" + name + ", deviceTypes=" + deviceTypes + "]";
	}
	
	
}
