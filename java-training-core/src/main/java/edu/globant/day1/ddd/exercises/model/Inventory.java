package edu.globant.day1.ddd.exercises.model;

import java.util.HashMap;

public class Inventory {

	private static HashMap<Case, Integer> inventory;

	public static HashMap<Case, Integer> getInventory() {
		return inventory;
	}

}
