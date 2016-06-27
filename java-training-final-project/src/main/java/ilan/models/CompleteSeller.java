package ilan.models;

import java.util.Date;

import ilan.interfaces.DeliverySellerInterface;
import ilan.interfaces.StoreSellerInterface;


public class CompleteSeller extends CaseSeller implements DeliverySellerInterface,StoreSellerInterface{

	public CompleteSeller() {}
	
	public CompleteSeller(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
}
