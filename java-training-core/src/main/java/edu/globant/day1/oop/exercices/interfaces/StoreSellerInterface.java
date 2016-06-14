package edu.globant.day1.oop.exercices.interfaces;

import java.util.Date;

import edu.globant.day1.oop.exercices.models.CaseSeller;
import edu.globant.day1.oop.exercices.models.Sale;


public interface StoreSellerInterface {
	
	default void sellCase(Sale sale, CaseSeller me){}
}
