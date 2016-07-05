package edu.globant.finalproject.model.Sale;

import java.util.ArrayList;

import org.apache.commons.lang3.Validate;

import edu.globant.finalproject.model.Case.CaseDTO;
import edu.globant.finalproject.model.Customer.CustomerDTO;
import edu.globant.finalproject.model.Employee.SellerDTO;



public abstract class SaleDTO {
	protected String status;
	protected SellerDTO seller;
	protected CustomerDTO customer;
	protected ArrayList<CaseDTO> cases;
	
	public SaleDTO(String status,SellerDTO seller,CustomerDTO customer, ArrayList<CaseDTO> cases){
		Validate.notBlank(status,"Status cannot be blank");
		Validate.notNull(seller,"seller cannot be null");
		Validate.notNull(customer,"customer cannot be null");
		Validate.notNull(cases,"cases cannot be null");
		Validate.notEmpty(cases,"cases cannot be empty");
		
		this.status = status;
		this.seller = seller;
		this.customer = customer;
		this.cases = cases;
	}

	public ArrayList<CaseDTO> getCases() {
		return cases;
	}

	public void setCases(ArrayList<CaseDTO> cases) {
		this.cases = cases;
	}

	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}

	public SellerDTO getSeller() {
		return seller;
	}

	public void setSeller(SellerDTO seller) {
		this.seller = seller;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}		
}
