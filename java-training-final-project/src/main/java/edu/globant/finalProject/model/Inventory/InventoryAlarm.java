package edu.globant.finalProject.model.Inventory;

import java.util.Observable;

import edu.globant.finalProject.model.Case.Case;

public class InventoryAlarm extends Observable{	
	
	public void shootAlarm(Case c){
		setChanged();
		notifyObservers("Low stock of case: "+c.getName());
	}
	
}
