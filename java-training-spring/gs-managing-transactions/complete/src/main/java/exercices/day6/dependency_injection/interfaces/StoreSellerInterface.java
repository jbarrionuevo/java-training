package exercices.day6.dependency_injection.interfaces;

import java.util.Date;

import exercices.day6.dependency_injection.models.CaseSeller;
import exercices.day6.dependency_injection.models.Sale;

public interface StoreSellerInterface {
	
	default void sellCase(Sale sale, CaseSeller me){}
}
