package interfaces;

import java.util.Date;

import classes.Case;
import classes.Logistic;
import classes.Order;
import classes.Receipt;
import classes.Sale;
import classes.StoreOrder;
import enums.SaleStatus;

public interface StoreSellerInterface {
	
	default void sellCase(Sale sale, Logistic logistic){
		StoreOrder order = sale.getOrder();
		sale.setReceipt(new Receipt("Fravega", order.getQuantity(), order.getOwner(),new Date(), order.getMyCase().getPrice()));
		sale.setStatus(SaleStatus.PAID);
		logistic.removeCaseFromInventory(order.getMyCase(),order.getQuantity());
	}
}
