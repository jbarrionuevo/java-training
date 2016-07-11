package edu.globant.domain;

import org.apache.commons.lang3.Validate;

public class Store extends BaseEntity {
	private String name;
	private String address;

	public Store(String name, String address) {
		Validate.notBlank(name, "The name cannot be blank.");
		Validate.notBlank(address, "The address cannot be blank.");
		Validate.notNull(name, "The name cannot be null.");
		Validate.notNull(address, "The address cannot be null.");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
