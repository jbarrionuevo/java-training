package domain;

import persistence.DAO.DTO;

public class Provider implements DTO{
	public String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
