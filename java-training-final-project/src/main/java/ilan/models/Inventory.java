package ilan.models;

import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Inventory {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private static HashMap<Case, Integer> inventory = null;

	private Inventory() {}

	public static HashMap<Case, Integer> getInventory() {
		if (inventory == null) {
			inventory = new HashMap<Case, Integer>();
		}
		return inventory;
	}
	
	
}
