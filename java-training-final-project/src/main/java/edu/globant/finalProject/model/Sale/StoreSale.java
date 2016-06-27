package edu.globant.finalProject.model.Sale;

import java.util.ArrayList;

import org.apache.commons.lang3.Validate;

import edu.globant.finalProject.model.Case.Case;
import edu.globant.finalProject.model.Customer.Customer;
import edu.globant.finalProject.model.Employee.Seller;

public class StoreSale extends Sale{
	private String store;
	
	public StoreSale(String store,String status, Seller seller, Customer customer,ArrayList<Case> cases){
		super(store, seller, customer, cases);
		
		Validate.notBlank(store);
		this.store = store;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}
	
	
}
