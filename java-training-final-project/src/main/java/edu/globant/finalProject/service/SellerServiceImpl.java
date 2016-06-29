package edu.globant.finalProject.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.globant.finalProject.dao.SellerDAO;
import edu.globant.finalProject.model.Sale.Receipt;
import edu.globant.finalProject.model.Sale.Sale;

@Service
public class SellerServiceImpl implements SellerService{
	
	@Autowired
	SellerDAO sellerDAO;

	@Transactional
	@Override
	public void registerAllSales(ArrayList<Sale> sales) {
		System.out.println("Registering all sales...");
		//TODO: ver cómo manejar esto
		//sales.forEach(s -> sellerDAO.sell(s));
	}

	@Transactional
	@Override
	public void registerSale(Sale sale) {
		Calendar date = GregorianCalendar.getInstance();
		
		//TODO: vér como solucionar la suma de 30 dias a la garantía
		Receipt receipt = new Receipt(date.getTime(), date.getTime() , sale);
	
		sellerDAO.sell(receipt);	
	}

}
