package exercices.day6.dependency_injection;

import java.util.HashMap;

public class Inventory {
	
	private static HashMap<Case, Integer> inventory = null;

	private Inventory() {}

	public static HashMap<Case, Integer> getInventory() {
		if (inventory == null) {
			inventory = new HashMap<Case, Integer>();
		}
		return inventory;
	}
	
	
}
