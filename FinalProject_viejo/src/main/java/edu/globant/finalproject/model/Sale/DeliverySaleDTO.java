package edu.globant.finalproject.model.Sale;

import java.util.ArrayList;

import edu.globant.finalproject.model.Case.CaseDTO;
import edu.globant.finalproject.model.Customer.CustomerDTO;
import edu.globant.finalproject.model.Employee.SellerDTO;



public class DeliverySaleDTO extends SaleDTO{

	public DeliverySaleDTO(String status, SellerDTO seller, CustomerDTO customer,ArrayList<CaseDTO> cases) {
		super(status, seller, customer, cases);
	}
	
}
