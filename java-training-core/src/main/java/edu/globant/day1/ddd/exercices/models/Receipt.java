package edu.globant.day1.ddd.exercices.models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Receipt {
	private String storeName;
	private Order order;
	private Date dateOfSale;
	private Customer customer;
	
	public Receipt(String storeName, Date dateOfSale,Order order, Customer customer) {
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


	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	

	
}
