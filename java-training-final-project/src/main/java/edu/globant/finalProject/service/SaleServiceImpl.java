package edu.globant.finalProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.globant.finalProject.dao.SaleDAO;
import edu.globant.finalProject.model.Sale.Sale;

@Service
public class SaleServiceImpl implements SaleService{
	
	@Autowired
	private SaleDAO saleDAO;

	@Transactional
	@Override
	public void register(Sale s) {
		saleDAO.register(s);
	}

}
