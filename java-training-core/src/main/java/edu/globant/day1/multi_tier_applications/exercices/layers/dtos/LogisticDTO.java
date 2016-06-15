package edu.globant.day1.multi_tier_applications.exercices.layers.dtos;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import javax.validation.Valid;

public class LogisticDTO extends EmployeeDTO {
	
	@Valid
	private InventoryDTO inventory;
	
	public LogisticDTO(String name, InventoryDTO inventory) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public InventoryDTO getInventory() {
		return inventory;
	}

	public void setInventory(InventoryDTO inventory) {
		this.inventory = inventory;
	}
	
	


}
