package edu.globant.day1.multi_tier_applications.exercices.layers.dtos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

public class ReceiptDTO {
	@NotNull
	private String storeName;
	@Valid
	private OrderDTO order;
	@NotNull
	@Past
	private Date dateOfSale;
	@Valid
	private CustomerDTO customer;
	
	public ReceiptDTO(String storeName, Date dateOfSale,OrderDTO order, CustomerDTO customer) {
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


	public OrderDTO getOrder() {
		return order;
	}

	public void setOrder(OrderDTO order) {
		this.order = order;
	}

	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}
	
	

	
}
