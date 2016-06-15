package edu.globant.day1.ddd.exercices.interfaces;

import edu.globant.day1.oop.exercices.models.DeliverySeller;
import edu.globant.day1.oop.exercices.models.Sale;

public interface DeliverySellerInterface {
	
	default void deliver(){}
	
	default void registerSales(DeliverySeller me){
		for(Sale sale: me.getSales()){
			//register sale
		}
	}
	
}
