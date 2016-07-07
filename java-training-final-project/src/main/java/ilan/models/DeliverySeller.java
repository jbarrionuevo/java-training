package ilan.models;

import java.util.Collection;

import ilan.interfaces.DeliverySellerInterface;


public class DeliverySeller extends CaseSeller implements DeliverySellerInterface {
	
	public DeliverySeller() {}
	
	public DeliverySeller(String name, String store) {
		super(name,store);
		// TODO Auto-generated constructor stub
	}
}
