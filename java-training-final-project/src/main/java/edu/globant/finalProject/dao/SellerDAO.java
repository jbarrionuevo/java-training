package edu.globant.finalProject.dao;

import edu.globant.finalProject.model.Sale.Sale;

public class SellerDAO {

	public void register(Sale s) {
		System.out.println("registering sale: "+s.toString());
		//deberia guardar en la bd en realidad
	}

}
