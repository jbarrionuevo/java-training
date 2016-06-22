package exercices.day6.dependency_injection.models;

import java.util.Date;

import exercices.day6.dependency_injection.interfaces.DeliverySellerInterface;
import exercices.day6.dependency_injection.interfaces.StoreSellerInterface;

public class CompleteSeller extends CaseSeller implements DeliverySellerInterface,StoreSellerInterface{

	public CompleteSeller() {}
	
	public CompleteSeller(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
}
