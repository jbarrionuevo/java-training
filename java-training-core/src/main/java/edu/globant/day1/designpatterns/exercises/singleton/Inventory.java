package edu.globant.day1.designpatterns.exercises.singleton;

import java.util.HashMap;

import edu.globant.day1.oop.exercises.model.Case;

public class Inventory {

	private static HashMap<Case, Integer> inventory = null;

	protected Inventory() {
		
	}

	public static HashMap<Case, Integer> getInventory() {
		if (inventory == null) {
			inventory = new HashMap<Case, Integer>();
		}
		return inventory;
	}
}
