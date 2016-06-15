package edu.globant.day1.designpatterns.exercices.strategy;

import java.util.Collection;

import edu.globant.day1.designpatterns.exercices.state.Sale;
import edu.globant.day1.oop.exercices.models.Employee;

public class CaseSeller extends Employee{
	
	//whenever a caseSeller receives an order, its a new sale with the DRAFT status; if then, the sale is not
	//succesfull, its marked as CANCELLED; otherwise, its marked as PAID, and it could then be REFUND
	private Collection<Sale> sales;
	private SellStrategy strategy;
	
	public CaseSeller(){}
	
	public CaseSeller(String name,SellStrategy strategy ){
		super(name);
		this.strategy=strategy;
	}
	
	public CaseSeller(String name, Collection<Sale> sales,SellStrategy strategy ) {
		super(name);
		this.sales = sales;
		this.strategy=strategy;
	}

	public void addSale(Sale sale){
		this.sales.add(sale);
	}
	
	public Collection<Sale> getSales() {
		return sales;
	}

	public void setSales(Collection<Sale> sales) {
		this.sales = sales;
	}

	public SellStrategy getStrategy() {
		return strategy;
	}

	public void setStrategy(SellStrategy strategy) {
		this.strategy = strategy;
	}

	
	
}
