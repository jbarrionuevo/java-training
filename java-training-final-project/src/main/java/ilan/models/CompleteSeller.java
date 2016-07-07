package ilan.models;

import java.util.Date;

import javax.persistence.Entity;

import ilan.interfaces.DeliverySellerInterface;
import ilan.interfaces.StoreSellerInterface;

@Entity
public class CompleteSeller extends CaseSeller implements DeliverySellerInterface,StoreSellerInterface{

	public CompleteSeller() {}
	
	public CompleteSeller(String name, String store) {
		super(name,store);
		// TODO Auto-generated constructor stub
	}
}
