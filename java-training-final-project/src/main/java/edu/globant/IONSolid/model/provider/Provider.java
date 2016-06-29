package edu.globant.IONSolid.model.provider;

import java.util.List;

import edu.globant.IONSolid.model.cases.CaseDesign;

public class Provider {
	
	private Long providerId;
	private String name;
	private String phoneNumber;
	private List<CaseDesign> providerDesignTypes; 
	
	public Provider(Long providerId, String name, String phoneNumber, CaseDesign ...designs) {
		this.providerId = providerId;
		this.setName(name);
		this.setPhoneNumber(phoneNumber);
		for(CaseDesign c : designs) {
			this.addProviderCaseDesignType(c);
		}
	}

	public Long getProviderId() {
		return providerId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<CaseDesign> getProviderType() {
		return providerDesignTypes;
	}

	public void addProviderCaseDesignType(CaseDesign design) {
		this.providerDesignTypes.add(design);
	}
}
