package edu.globant.finalproject.model.Sale;

import java.util.ArrayList;

import org.apache.commons.lang3.Validate;

import edu.globant.finalproject.model.Case.CaseDTO;
import edu.globant.finalproject.model.Customer.CustomerDTO;
import edu.globant.finalproject.model.Employee.SellerDTO;



public class StoreSaleDTO extends SaleDTO{
	private String store;
	
	public StoreSaleDTO(String store,String status, SellerDTO seller, CustomerDTO customer,ArrayList<CaseDTO> cases){
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
