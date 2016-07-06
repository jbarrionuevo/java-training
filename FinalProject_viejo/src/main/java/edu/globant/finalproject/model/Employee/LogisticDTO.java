package edu.globant.finalproject.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;

import edu.globant.finalproject.model.Inventory.InventoryDTO;


public class LogisticDTO extends EmployeeDTO{
	
	public LogisticDTO(String name) {
		super(name);
	}

	@Autowired
	private InventoryDTO inventory;
	

	public InventoryDTO getInventory() {
		return inventory;
	}

	public void setInventory(InventoryDTO inventory) {
		this.inventory = inventory;
	}
	
}
