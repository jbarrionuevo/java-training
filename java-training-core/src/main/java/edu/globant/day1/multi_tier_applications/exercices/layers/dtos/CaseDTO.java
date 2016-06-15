package edu.globant.day1.multi_tier_applications.exercices.layers.dtos;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CaseDTO {
	
	@Valid
	private CaseDesignDTO design;
	@Valid
	private CaseDeviceDTO device;
	@NotNull
	private double price;
	@Valid
	private ProviderDTO provider;
	
	public CaseDTO(CaseDesignDTO design, CaseDeviceDTO device, Double price, ProviderDTO provider) {
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
	
	public CaseDesignDTO getDesign() {
		return design;
	}
	public void setDesign(CaseDesignDTO design) {
		this.design = design;
	}
	public CaseDeviceDTO getDevice() {
		return device;
	}
	public void setDevice(CaseDeviceDTO device) {
		this.device = device;
	}


	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public ProviderDTO getProvider() {
		return provider;
	}

	public void setProvider(ProviderDTO provider) {
		this.provider = provider;
	}
	
	
}
