package edu.globant.day1.designpatterns.exercices.observer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import edu.globant.day1.oop.exercices.models.Case;

public class Inventory implements InventorySubject{
	
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
	
	public static void addCase(Case aCase, int quantity){
		//if inventory has a CaseWrapper for that type of case
			//update it
		//else
		   //create new casewrapper for that type of case, then update it
	}
	
	public static void removeCase(Case aCase, int quantity){
		//if inventory has a CaseWrapper for that type of case
			//update it
		//else
			//create new casewrapper for that type of case, then update it
	}

	@Override
	public void addObserver(InventoryObserver inventoryObserver) {
		inventoryObservers.add(inventoryObserver);
	}

	@Override
	public void removeObserver(InventoryObserver inventoryObserver) {
		inventoryObservers.remove(inventoryObserver);
	}

	private CaseWrapper getWrapperForCase(Case aCase){
		//return the wrapper for that case, which include its minimum stock and current stock
		return null;
	}
	@Override
	public void doNotify(Case aCase) {
		Iterator<InventoryObserver> it = inventoryObservers.iterator();
		CaseWrapper wrapperUpdated = getWrapperForCase(aCase);
		if(wrapperUpdated.getCurrentStock()<wrapperUpdated.getCurrentStock()){
			while (it.hasNext()) {
				InventoryObserver inventoryObserver = it.next();
				inventoryObserver.doUpdate(aCase);
			}
		}
	}
	
	
}
