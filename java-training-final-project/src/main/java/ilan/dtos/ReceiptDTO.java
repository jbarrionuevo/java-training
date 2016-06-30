package ilan.dtos;

import java.util.Date;

import org.thymeleaf.util.Validate;

public class ReceiptDTO {
	private Long id;
	private String storeName;
	private CaseOrderDTO caseOrder;
	private Date dateOfSale;
	private CustomerDTO customer;
	
	public ReceiptDTO(String storeName, Date dateOfSale,CaseOrderDTO order, CustomerDTO customer) {
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

	public CaseOrderDTO getCaseOrder() {
		return caseOrder;
	}

	public void setCaseOrder(CaseOrderDTO caseOrder) {
		this.caseOrder = caseOrder;
	}

	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}


	
}
