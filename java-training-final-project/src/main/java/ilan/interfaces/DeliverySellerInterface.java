package ilan.interfaces;

import ilan.models.DeliverySeller;
import ilan.models.Sale;

public interface DeliverySellerInterface {
	
	default void deliver(){}
	
	default void registerSales(DeliverySeller me){
		for(Sale sale: me.getSales()){
			//register sale
		}
	}
	
}
