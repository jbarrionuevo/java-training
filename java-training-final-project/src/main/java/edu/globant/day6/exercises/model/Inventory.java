package edu.globant.day6.exercises.model;

import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import edu.globant.day6.exercises.model.Case;

@Entity
public class Inventory {

	@Id
	@GeneratedValue
	private Long id;
	private static HashMap<Case, Integer> inventory;

	public static HashMap<Case, Integer> getInventory() {
		return inventory;
	}

}
