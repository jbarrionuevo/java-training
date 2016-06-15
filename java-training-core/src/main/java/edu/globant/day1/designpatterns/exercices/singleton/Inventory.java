package edu.globant.day1.designpatterns.exercices.singleton;

import java.util.HashMap;

import edu.globant.day1.oop.exercices.models.Case;

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
