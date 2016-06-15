package edu.globant.day1.designpatterns.exercices.observer;

import edu.globant.day1.oop.exercices.models.Case;

public class CaseWrapper {
	private Case aCase;
	private int minimumStock;
	private int currentStock;
	
	public CaseWrapper(Case aCase, int minimumStock, int currentStock) {
		super();
		this.aCase = aCase;
		this.minimumStock = minimumStock;
		this.currentStock = currentStock;
	}
	
	public Case getaCase() {
		return aCase;
	}
	public void setaCase(Case aCase) {
		this.aCase = aCase;
	}
	public int getMinimumStock() {
		return minimumStock;
	}
	public void setMinimumStock(int minimumStock) {
		this.minimumStock = minimumStock;
	}
	public int getCurrentStock() {
		return currentStock;
	}
	public void setCurrentStock(int currentStock) {
		this.currentStock = currentStock;
	}
	
	
}
