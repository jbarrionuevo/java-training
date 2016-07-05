package edu.globant.finalproject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.globant.finalproject.dao.SaleDAOImpl;
import edu.globant.finalproject.model.Sale.SaleDTO;

@Service
public class SaleServiceImpl implements SaleService{
	
	@Autowired
	private SaleDAOImpl saleDAO;

	@Transactional
	@Override
	public void register(SaleDTO s) {
		saleDAO.register(s);
	}

}
