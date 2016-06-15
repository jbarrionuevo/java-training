package edu.globant.day1.multi_tier_applications.exercices.layers.dtos;

import java.util.Date;

import edu.globant.day1.oop.exercices.interfaces.DeliverySellerInterface;
import edu.globant.day1.oop.exercices.interfaces.StoreSellerInterface;


public class CompleteSellerDTO extends CaseSellerDTO implements DeliverySellerInterface,StoreSellerInterface{

	public CompleteSellerDTO() {}
	
	public CompleteSellerDTO(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
}
