package edu.globant.finalproject.model.Sale;


import java.util.Date;

import org.apache.commons.lang3.Validate;

public class ReceiptDTO {
	private Date creationDate;
	private Date warrantyDate;
	private SaleDTO sale;
	
	public ReceiptDTO(Date creationDate, Date warrantyDate,SaleDTO sale){
		Validate.notNull(creationDate,"Creation Date cannot be null");
		Validate.notNull(creationDate,"Warranty Date cannot be null");
		Validate.notNull(sale,"Sale cannot be null");
		
		this.creationDate = creationDate;
		this.warrantyDate = warrantyDate;
		this.sale = sale;
	}
	
	public SaleDTO getSale() {
		return sale;
	}
	public void setSale(SaleDTO sale) {
		this.sale = sale;
	}
	public Date getDate() {
		return creationDate;
	}
	public void setDate(Date date) {
		this.creationDate = date;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getWarrantyDate() {
		return warrantyDate;
	}
	public void setWarrantyDate(Date warrantyDate) {
		this.warrantyDate = warrantyDate;
	}
	
	
}
