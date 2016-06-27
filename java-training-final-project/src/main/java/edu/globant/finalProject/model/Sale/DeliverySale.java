package edu.globant.finalProject.model.Sale;

import java.util.ArrayList;

import edu.globant.finalProject.model.Case.Case;
import edu.globant.finalProject.model.Customer.Customer;
import edu.globant.finalProject.model.Employee.Seller;

public class DeliverySale extends Sale{

	public DeliverySale(String status, Seller seller, Customer customer,ArrayList<Case> cases) {
		super(status, seller, customer, cases);
	}
	
}
