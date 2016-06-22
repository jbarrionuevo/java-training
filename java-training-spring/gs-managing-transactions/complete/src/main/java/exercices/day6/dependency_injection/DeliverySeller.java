package exercices.day6.dependency_injection;

import java.util.Collection;

import exercices.day6.dependency_injection.interfaces.DeliverySellerInterface;

public class DeliverySeller extends CaseSeller implements DeliverySellerInterface {
	
	public DeliverySeller() {}
	
	public DeliverySeller(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
}
