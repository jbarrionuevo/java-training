package ilan.models;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.thymeleaf.util.Validate;

import ilan.dtos.ReceiptDTO;
import ilan.enums.SaleStatus;

@Entity
@Table(indexes = {@Index(columnList = "status", name = "sale_status")})
public class Sale {
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "sale", cascade = CascadeType.ALL)
	private Collection<Receipt> receipts;
	
	@OneToOne
	private CaseOrder caseOrder;
	
	@ManyToOne
	CaseSeller seller;
	
	private SaleStatus status;
	
	public Sale(){}
	
	public Sale(CaseOrder order, Collection<Receipt> receipts) {
		super();
		Validate.notNull(order,"Order cannot be null");
		this.caseOrder=order;
		this.status = SaleStatus.DRAFT;
		this.receipts=receipts;
	}

	public Customer getCustomer(){
		return receipts.iterator().next().getCustomer();
	}
	
	public Collection<Receipt> getReceipts() {
		return receipts;
	}

	public void setReceipts(Collection<Receipt> receipts) {
		this.receipts = receipts;
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

	public CaseSeller getSeller() {
		return seller;
	}

	public void setSeller(CaseSeller seller) {
		this.seller = seller;
	}

	
	
	
	
}
