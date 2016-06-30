package ilan.dtos;

import java.util.Date;

import org.thymeleaf.util.Validate;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import ilan.models.Sale;

public class ReceiptDTO {
	private Long id;
	private String storeName;
	private Date dateOfSale;
	private CustomerDTO customer;
	private SaleDTO sale;
	
	@JsonCreator
	public ReceiptDTO(){}
	
	@JsonCreator
	public ReceiptDTO(@JsonProperty("storeName") String storeName,
			@JsonProperty("dateOfSale") Date dateOfSale,
			@JsonProperty("customer") CustomerDTO customer){
		this.dateOfSale = dateOfSale;
		this.storeName = storeName;
		this.customer=customer;
	}
//	
//	public ReceiptDTO(String storeName, Date dateOfSale,CustomerDTO customer) {
//		this.storeName = storeName;
//		this.dateOfSale = dateOfSale;
//		this.customer=customer;
//	}
	
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}

	public SaleDTO getSale() {
		return sale;
	}

	public void setSale(SaleDTO sale) {
		this.sale = sale;
	}


	
}
