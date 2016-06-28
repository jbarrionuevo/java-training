package edu.globant.day1.ddd.exercices.models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Receipt {
	private String storeName;
	private CaseOrder order;
	private Date dateOfSale;
	private Customer customer;
	private int id;
	
	public Receipt(String storeName, Date dateOfSale,CaseOrder order, Customer customer) {
		super();
		this.storeName = storeName;
		this.dateOfSale = dateOfSale;
		this.order=order;
		this.customer=customer;
	}
	
	@Override
	public String toString(){
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return String.format("Receipt: Store name: %s; Quantity: %d; Customer: [%s];"
				+ "Date: %s", this.getStoreName(), this.getOrder().getQuantity(),
				this.getCustomer(), df.format(this.getDateOfSale()));
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public Date getDateOfSale() {
		return dateOfSale;
	}

	public void setDateOfSale(Date dateOfSale) {
		this.dateOfSale = dateOfSale;
	}


	public CaseOrder getOrder() {
		return order;
	}

	public void setOrder(CaseOrder order) {
		this.order = order;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

	
}
