package edu.globant.finalProject.service;

import edu.globant.finalProject.model.Case.Case;
import edu.globant.finalProject.model.Provider.Provider;
import edu.globant.finalProject.model.Sale.Sale;

public class LogisticServiceImpl implements LogisticService{

	@Override
	public void orderToProvider(Provider p, Case c) {
		System.out.println("making an order to: "+p.getName()+" of case: "+c.getName());
	}

	@Override
	public void registerASale(Sale s) {
		System.out.println("Registering a sale: "+s.toString());
		
		//TODO: cómo hago para consultarle el lowStock? porque no lo tiene Case, lo tiene el ServiceCaseImpl
//		for (Case c : s.getReceipt().getCases()) {
//			if(c.hasLowStock()){
//				
//			}
//		}
	}
	
}
