package edu.globant.finalProject.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;

import edu.globant.finalProject.dao.SellerDAO;
import edu.globant.finalProject.model.Case.Case;
import edu.globant.finalProject.model.Customer.Customer;
import edu.globant.finalProject.model.Sale.Receipt;
import edu.globant.finalProject.model.Sale.Sale;

public class SellerServiceImpl implements SellerService{
	
	@Autowired
	SellerDAO sellerDAO;

	@Override
	public void registerAllSales(ArrayList<Sale> sales) {
		System.out.println("Registering all sales...");
		//TODO: ver cómo manejar esto
		//sales.forEach(s -> sellerDAO.sell(s));
	}

	@Override
	public void registerSale(Sale sale) {
		Calendar date = GregorianCalendar.getInstance();
		
		//TODO: vér como solucionar la suma de 30 dias a la garantía
		Receipt receipt = new Receipt(date.getTime(), date.getTime() , sale);
	
		sellerDAO.sell(receipt);	
	}

}
