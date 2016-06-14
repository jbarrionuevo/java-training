package dia1.models;

import java.util.Collection;

import dia1.interfaces.DeliverySellerInterface;


public class DeliverySeller extends CaseSeller implements DeliverySellerInterface {
	
	public static void main(String args[]){
		DeliverySeller test = new DeliverySeller();
		test.registerOrder(new StoreOrder());
		test.deliver(); //testing interface default methods
	}
}
