package dia1.interfaces;

import dia1.models.DeliverySeller;
import dia1.models.Sale;

public interface DeliverySellerInterface {
	
	default void deliver(){}
	
	default void registerSales(DeliverySeller me){
		for(Sale sale: me.getSales()){
			//register sale
		}
	}
	
}
