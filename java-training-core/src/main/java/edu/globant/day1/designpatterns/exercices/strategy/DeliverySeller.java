package edu.globant.day1.designpatterns.exercices.strategy;

import java.util.Collection;

import edu.globant.day1.oop.exercices.interfaces.DeliverySellerInterface;


public class DeliverySeller extends CaseSeller implements SellStrategy, DeliverySellerInterface {
	
	public DeliverySeller() {}
	
	public DeliverySeller(String name) {
		super(name,new DeliverySeller());
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void sell() {
		System.out.println("Implement its selling strategy");
	}
}
