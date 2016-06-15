package edu.globant.day1.ddd.exercices.models;

import java.util.Collection;

import edu.globant.day1.oop.exercices.interfaces.DeliverySellerInterface;


public class DeliverySeller extends CaseSeller implements DeliverySellerInterface {
	
	public DeliverySeller() {}
	
	public DeliverySeller(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
}
