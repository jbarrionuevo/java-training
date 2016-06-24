package edu.globant.day6.exercises.model;

import java.util.HashMap;

public class Inventory {

	private static HashMap<Case, Integer> inventory;

	public static HashMap<Case, Integer> getInventory() {
		return inventory;
	}

}
