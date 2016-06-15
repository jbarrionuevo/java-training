package edu.globant.day1.designpatterns.exercices.factory;

import edu.globant.day1.oop.exercices.models.CaseSeller;
import edu.globant.day1.oop.exercices.models.CompleteSeller;
import edu.globant.day1.oop.exercices.models.DeliverySeller;
import edu.globant.day1.oop.exercices.models.StoreSeller;

public class CaseSellerFactory {
	public CaseSeller getCaseSeller(String type){
		if("store".equals(type)) return new StoreSeller();
		else if("delivery".equals(type)) return new DeliverySeller();
		return new CompleteSeller();
	}
}
