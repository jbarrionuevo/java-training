package edu.globant.IONSolid.model.provider;

public class Provider {
	
	private String name;
	private String phoneNumber;
	private String providerType; //Podria ser un enum
	
	public Provider(String name, String phoneNumber, String providerType) {
		this.setName(name);
		this.setPhoneNumber(phoneNumber);
		this.setProviderType(providerType);
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

	public String getProviderType() {
		return providerType;
	}

	public void setProviderType(String providerType) {
		this.providerType = providerType;
	}
}
