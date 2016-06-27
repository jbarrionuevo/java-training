package ilan.interfaces;

import java.util.Date;

import ilan.models.CaseSeller;
import ilan.models.Sale;


public interface StoreSellerInterface {
	
	default void sellCase(Sale sale, CaseSeller me){}
}
