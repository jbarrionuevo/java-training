package edu.globant.day1.oop.exercises.Employee;


import java.util.Observable;

import edu.globant.day1.oop.exercises.Case.Case;

public class StockAlert extends Observable{
	public void alarm(Case casee){
		setChanged();
		notifyObservers("The amount of "+casee.toString()+" is too low");	
	}
}
