package ilan.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.thymeleaf.util.Validate;

import ilan.enums.SaleStatus;

@Entity
@Table(indexes = {@Index(columnList = "status", name = "sale_status")})
public class Sale {
	@Id
	@GeneratedValue
	private Long id;
	@OneToOne
	private Receipt receipt;
	
	@OneToOne
	private CaseOrder caseOrder;
	
	@ManyToOne
	CaseSeller seller;
	
	private SaleStatus status;
	
	public Sale(CaseOrder order) {
		super();
		Validate.notNull(order,"Order cannot be null");
		this.caseOrder=order;
		this.status = SaleStatus.DRAFT;
	}
	
	public Receipt getReceipt() {
		return receipt;
	}
	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	public SaleStatus getStatus() {
		return status;
	}

	public void setStatus(SaleStatus status) {
		this.status = status;
	}

	public CaseOrder getOrder() {
		return caseOrder;
	}

	public void setOrder(CaseOrder order) {
		this.caseOrder = order;
	}

	
	
	
	
}
