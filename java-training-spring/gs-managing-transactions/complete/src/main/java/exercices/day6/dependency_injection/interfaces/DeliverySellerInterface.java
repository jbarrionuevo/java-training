package exercices.day6.dependency_injection.interfaces;

import exercices.day6.dependency_injection.DeliverySeller;
import exercices.day6.dependency_injection.Sale;

public interface DeliverySellerInterface {
	
	default void deliver(){}
	
	default void registerSales(DeliverySeller me){
		for(Sale sale: me.getSales()){
			//register sale
		}
	}
	
}
