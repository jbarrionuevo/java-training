package edu.globant.day1.oop.exercices.models;

import java.util.Date;

import edu.globant.day1.oop.exercices.interfaces.DeliverySellerInterface;
import edu.globant.day1.oop.exercices.interfaces.StoreSellerInterface;


public class CompleteSeller extends CaseSeller implements DeliverySellerInterface,StoreSellerInterface{

	public CompleteSeller(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
}
