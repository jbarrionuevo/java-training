package edu.globant.day1.oop.exercises.Sale;

import edu.globant.day1.oop.exercises.Case.Case;
import edu.globant.day1.oop.exercises.Employee.Logistic;
import edu.globant.day1.oop.exercises.Employee.StockAlert;



public abstract class Sale {
	private TypeOfSale typeOfSale;
	private Receipt receipt;
	private String status; //podría haber utilizado el pattern State, pero como no indica distinto comportamiento, opté por esta solución.
	
	
	public TypeOfSale getTypeOfSale() {
		return typeOfSale;
	}



	public void setTypeOfSale(TypeOfSale typeOfSale) {
		this.typeOfSale = typeOfSale;
	}



	public Receipt getReceipt() {
		return receipt;
	}



	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}



	public void register() {
		System.out.println("Registering sale...");
		for (Case c : getReceipt().getCases()) {
			if(c.hasLowStock()){
				StockAlert s = new StockAlert();
				s.addObserver(new Logistic());
				s.alarm(c);
			}	
		}
	}
			
}
