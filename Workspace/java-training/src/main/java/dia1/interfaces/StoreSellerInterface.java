package dia1.interfaces;

import java.util.Date;

import dia1.enums.SaleStatus;
import dia1.models.CaseSeller;
import dia1.models.Receipt;
import dia1.models.Sale;
import dia1.models.StoreOrder;
import dia1.models.StoreSeller;

public interface StoreSellerInterface {
	
	default void sellCase(Sale sale, CaseSeller me){
		StoreOrder order = sale.getOrder();
		sale.setReceipt(new Receipt(((StoreSeller)me).getStore(), order.getQuantity(), order.getOwner(),new Date(), order.getMyCase().getPrice()));
		sale.setStatus(SaleStatus.PAID);
		me.getLogistic().removeCaseFromInventory(order.getMyCase(),order.getQuantity());
	}
}
