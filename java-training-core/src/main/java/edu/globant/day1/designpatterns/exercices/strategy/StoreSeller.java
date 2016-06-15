package edu.globant.day1.designpatterns.exercices.strategy;

import java.util.Collection;
import java.util.Date;

import edu.globant.day1.designpatterns.exercices.state.Sale;
import edu.globant.day1.oop.exercices.interfaces.StoreSellerInterface;


public class StoreSeller extends CaseSeller implements SellStrategy,StoreSellerInterface{

	private String store;
	
	public StoreSeller(){}
	
	public StoreSeller(String name){
		super(name, new StoreSeller());
	}
	
	@Override
	public void sell() {
		System.out.println("Implement its selling strategy");
	}
	
	public StoreSeller(String name,Collection<Sale> sales, String store){
		super(name,sales,new StoreSeller());
		this.store=store;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}
}
