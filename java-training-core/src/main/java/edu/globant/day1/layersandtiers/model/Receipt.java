package edu.globant.day1.layersandtiers.model;


import java.util.ArrayList;
import java.util.Date;

import edu.globant.day1.oop.exercises.Case.Case;
import edu.globant.day1.oop.exercises.Customer.Customer;

public class Receipt {
	private Customer customer;
	private Date date;
	private ArrayList<Case> cases;
	private String nameOfStore;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public ArrayList<Case> getCases() {
		return cases;
	}
	public void setCases(ArrayList<Case> cases) {
		this.cases = cases;
	}
	public String getNameOfStore() {
		return nameOfStore;
	}
	public void setNameOfStore(String nameOfStore) {
		this.nameOfStore = nameOfStore;
	}
	
	
}
