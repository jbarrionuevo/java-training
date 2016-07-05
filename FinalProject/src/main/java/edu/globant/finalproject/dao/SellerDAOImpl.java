package edu.globant.finalproject.dao;

import org.apache.commons.lang3.Validate;
import org.springframework.stereotype.Repository;

import edu.globant.finalproject.model.Sale.ReceiptDTO;


@Repository
public class SellerDAOImpl implements SellerDAO{

//	public void register(Sale s) {
//		Validate.notNull(s,"The sale cannot be null");
//		System.out.println("registering sale: "+s.toString());
//		//deberia guardar en la bd en realidad
//	}

	public void sell(ReceiptDTO receipt) {
		Validate.notNull(receipt,"The receipt cannot be null");
		System.out.println("selling a sale");
		
	}

}
