package edu.globant.finalProject.model.Employee;


import java.util.Observable;

import edu.globant.finalProject.model.Case.Case;


public class StockAlert extends Observable{
	public void alarm(Case casee){
		setChanged();
		notifyObservers("The amount of "+casee.toString()+" is too low");	
	}
}
