package edu.globant.finalproject.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import edu.globant.finalproject.dao.SellerDAOImpl;
import edu.globant.finalproject.model.Sale.ReceiptDTO;
import edu.globant.finalproject.model.Sale.SaleDTO;

@Service
public class SellerServiceImpl implements SellerService{
	
	@Autowired
	SellerDAOImpl sellerDAO;

	@Transactional
	public void registerSale(SaleDTO sale) {
		Calendar date = GregorianCalendar.getInstance();
		
		//TODO: vér como solucionar la suma de 30 dias a la garantía
		ReceiptDTO receipt = new ReceiptDTO(date.getTime(), date.getTime() , sale);
	
		sellerDAO.sell(receipt);	
	}

	@Transactional
	public void registerAllSales(ArrayList<SaleDTO> sales) {
		System.out.println("Registering all sales...");
		//TODO: ver cómo manejar esto
		//sales.forEach(s -> sellerDAO.sell(s));
	}
}
