package edu.globant.finalproject.model.Inventory;

import java.util.Observable;

import edu.globant.finalproject.model.Case.CaseDTO;


public class InventoryAlarm extends Observable{	
	
	public void shootAlarm(CaseDTO c){
		setChanged();
		notifyObservers("Low stock of case: "+c.getName());
	}
	
}
