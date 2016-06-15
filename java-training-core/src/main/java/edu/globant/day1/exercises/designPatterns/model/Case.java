package edu.globant.day1.exercises.designPatterns.model;

import java.util.HashSet;
import java.util.Set;

public class Case {
	
	private int id;
	private CaseDesign caseDesign;
	private Set<Device> compatibleDevices = new HashSet<Device>();
	private double price;
	private CaseStock caseStock;
	
	public Case(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CaseDesign getCaseDesign() {
		return caseDesign;
	}

	public void setCaseDesign(CaseDesign caseDesign) {
		this.caseDesign = caseDesign;
	}

	public Set<Device> getCompatibleDevices() {
		return compatibleDevices;
	}

	public void setCompatibleDevices(Set<Device> compatibleDevices) {
		this.compatibleDevices = compatibleDevices;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public CaseStock getCaseStock() {
		return caseStock;
	}

	public void setCaseStock(CaseStock caseStock) {
		this.caseStock = caseStock;
	}

	@Override
	public String toString() {
		return "Case [id=" + id + ", caseDesign=" + caseDesign + ", compatibleDevices=" + compatibleDevices + ", price="
				+ price + ", caseStock=" + caseStock + "]";
	}
	
	
}
