package edu.globant.day1.multi_tier_applications.exercices.layers.dtos;

import java.util.HashMap;

import javax.validation.Valid;

public class InventoryDTO {
	
	@Valid
	private static HashMap<CaseDTO, Integer> inventory = null;

	private InventoryDTO() {}

	public static HashMap<CaseDTO, Integer> getInventory() {
		if (inventory == null) {
			inventory = new HashMap<CaseDTO, Integer>();
		}
		return inventory;
	}
	
	
}
