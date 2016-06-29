package edu.globant.day6.exercises.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.globant.day6.exercises.DAO.SaleServiceDAO;

@Service
public class SaleService {
	
	@Autowired
	SaleServiceDAO saleServiceDAO;

	public SaleServiceDAO getSaleServiceDAO() {
		return saleServiceDAO;
	}

	public void setSaleServiceDAO(SaleServiceDAO saleServiceDAO) {
		this.saleServiceDAO = saleServiceDAO;
	}
}
