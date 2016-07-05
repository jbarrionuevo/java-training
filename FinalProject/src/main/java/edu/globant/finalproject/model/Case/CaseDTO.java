package edu.globant.finalproject.model.Case;

import java.util.ArrayList;
import java.util.TreeSet;

import org.apache.commons.lang3.Validate;

import edu.globant.finalproject.hibernate.BaseEntity;
import edu.globant.finalproject.model.Provider.ProviderDTO;

public abstract class CaseDTO{
	
	private String name;
	private String code;
	//TODO: debería autoasignarse
	private ProviderDTO provider;
	private ArrayList<DeviceDTO> devices;
	private DesignDTO design;
	protected double price;

	public CaseDTO(String name,String code,ArrayList<DeviceDTO> devices, DesignDTO design, double price) {
		
		Validate.notBlank(name,"The name cannot be blank");
		Validate.notBlank(code,"The name cannot be blank");
		Validate.notEmpty(devices,"It must have at least one device");
		Validate.notNull(design,"The design cannot be null");
		Validate.notNull(price,"The price cannot be null");
		
		this.name = name;
		this.code = code;
		this.devices = devices;
		this.design = design;
		this.price = price;
	}

	public DesignDTO getDesign() {
		return design;
	}

	public void setDesign(DesignDTO design) {
		this.design = design;
	}

	public ArrayList<DeviceDTO> getDevices() {
		return devices;
	}

	public void setDevices(ArrayList<DeviceDTO> devices) {
		this.devices = devices;
	}

	public ProviderDTO getProvider() {
		return provider;
	}

	public void setProvider(ProviderDTO provider) {
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
}
