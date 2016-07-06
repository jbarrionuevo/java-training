package edu.globant.finalproject.dao;

import org.springframework.stereotype.Repository;

import edu.globant.finalproject.model.Sale.SaleDTO;

@Repository
public class SaleDAOImpl implements SaleDAO{

	public void register(SaleDTO s) {
		System.out.println("Registering a sale");
	}

}
