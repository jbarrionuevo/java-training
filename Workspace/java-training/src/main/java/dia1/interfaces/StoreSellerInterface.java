package dia1.interfaces;

import java.util.Date;

import dia1.enums.SaleStatus;
import dia1.models.CaseSeller;
import dia1.models.Order;
import dia1.models.Receipt;
import dia1.models.Sale;
import dia1.models.StoreSeller;

public interface StoreSellerInterface {
	
	default void sellCase(Sale sale, CaseSeller me){}
}
