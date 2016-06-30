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
	
	private Date dateOfSale;
	
	@ManyToOne
	Sale sale;
	
	@ManyToOne
	private Customer customer;
	
	public Receipt(){}
	
	public Receipt(String storeName, Date dateOfSale, Customer customer) {
		super();
		Validate.notNull(dateOfSale,"Date of sale cannot be null");
		Validate.notEmpty(storeName,"Store Name cannot be blank");
		Validate.notNull(customer,"Customer cannot be null");
		this.storeName = storeName;
		this.dateOfSale = dateOfSale;
		this.customer=customer;
	}
	
	@Override
	public String toString(){
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return String.format("Receipt: Store name: %s; Customer: [%s];"
				+ "Date: %s", this.getStoreName(),
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}
	
	

	
}
