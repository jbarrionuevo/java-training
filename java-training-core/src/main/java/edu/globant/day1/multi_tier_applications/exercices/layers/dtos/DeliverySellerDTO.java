package edu.globant.day1.multi_tier_applications.exercices.layers.dtos;

import java.util.Collection;

import edu.globant.day1.oop.exercices.interfaces.DeliverySellerInterface;


public class DeliverySellerDTO extends CaseSellerDTO implements DeliverySellerInterface {
	
	public DeliverySellerDTO() {}
	
	public DeliverySellerDTO(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
}
