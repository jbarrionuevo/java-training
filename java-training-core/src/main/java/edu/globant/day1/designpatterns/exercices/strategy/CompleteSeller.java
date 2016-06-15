package edu.globant.day1.designpatterns.exercices.strategy;

import java.util.Date;

import edu.globant.day1.oop.exercices.interfaces.DeliverySellerInterface;
import edu.globant.day1.oop.exercices.interfaces.StoreSellerInterface;


public class CompleteSeller extends CaseSeller implements SellStrategy,DeliverySellerInterface,StoreSellerInterface{

	public CompleteSeller() {}
	
	public CompleteSeller(String name) {
		super(name,new CompleteSeller());
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sell() {
		System.out.println("Implement its selling strategy");
	}
}
