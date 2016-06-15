package edu.globant.day1.ddd.exercices.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import edu.globant.day1.designpatterns.exercices.observer.CaseWrapper;
import edu.globant.day1.designpatterns.exercices.observer.InventoryObserver;

public class Inventory {
	
private static Inventory instance = null;
	
	private static Collection<CaseWrapper> inventory = new ArrayList<CaseWrapper>();
	private static Set<InventoryObserver> inventoryObservers;

	private Inventory() {}

	public static Inventory getInstance() {
		if (instance == null) {
			instance = new Inventory();
		}
		return instance;
	}
	
	
}
