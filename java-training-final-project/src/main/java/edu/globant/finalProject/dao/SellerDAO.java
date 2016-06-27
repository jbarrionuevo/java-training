package edu.globant.finalProject.dao;

import org.apache.commons.lang3.Validate;

import edu.globant.finalProject.model.Sale.Receipt;

public class SellerDAO {

//	public void register(Sale s) {
//		Validate.notNull(s,"The sale cannot be null");
//		System.out.println("registering sale: "+s.toString());
//		//deberia guardar en la bd en realidad
//	}

	public void sell(Receipt receipt) {
		Validate.notNull(receipt,"The receipt cannot be null");
		System.out.println("selling a sale");
		
	}

}
