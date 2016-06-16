package edu.globant.day2.exceptions.exercises;

import edu.globant.day1.oop.exercises.Case.Case;
import edu.globant.day1.oop.exercises.Employee.Logistic;
import edu.globant.day1.oop.exercises.Employee.StockAlert;
import edu.globant.day1.oop.exercises.Sale.Receipt;
import edu.globant.day1.oop.exercises.Sale.TypeOfSale;



public abstract class Sale {
	private TypeOfSale typeOfSale;
	private Receipt receipt;
	private String status; 
	
	
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



	public void register() throws SaleRegisterException{
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
