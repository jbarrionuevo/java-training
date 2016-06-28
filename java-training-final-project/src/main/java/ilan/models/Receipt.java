package ilan.models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.thymeleaf.util.Validate;

@Entity
public class Receipt {
	@Id
	@GeneratedValue
	private Long id;
	
	private String storeName;
	
	@OneToOne
	private CaseOrder caseOrder;
	private Date dateOfSale;
	
	@ManyToOne
	private Customer customer;
	
	public Receipt(String storeName, Date dateOfSale,CaseOrder order, Customer customer) {
		super();
		Validate.notNull(dateOfSale,"Date of sale cannot be null");
		Validate.notEmpty(storeName,"Store Name cannot be blank");
		Validate.notNull(order,"Order cannot be null");
		Validate.notNull(customer,"Customer cannot be null");
		this.storeName = storeName;
		this.dateOfSale = dateOfSale;
		this.caseOrder=order;
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
		return caseOrder;
	}

	public void setOrder(CaseOrder order) {
		this.caseOrder = order;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	

	
}