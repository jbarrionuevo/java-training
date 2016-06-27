package edu.globant.finalProject.model.Sale;

import java.util.ArrayList;

import org.apache.commons.lang3.Validate;

import edu.globant.finalProject.model.Case.Case;
import edu.globant.finalProject.model.Customer.Customer;
import edu.globant.finalProject.model.Employee.Seller;

public abstract class Sale {
	protected String status;
	protected Seller seller;
	protected Customer customer;
	protected ArrayList<Case> cases;
	
	public Sale(String status,Seller seller,Customer customer, ArrayList<Case> cases){
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

	public ArrayList<Case> getCases() {
		return cases;
	}

	public void setCases(ArrayList<Case> cases) {
		this.cases = cases;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}		
}
