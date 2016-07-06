package edu.globant.finalproject.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "caseStock")
public class CaseStock {
	
	@Autowired
	@OneToOne (cascade=CascadeType.ALL)
	  @JoinColumn(name="case_id", nullable=false, insertable=true, updatable=true)
	private Case kase;
	
	@Autowired
	@Column(name = "actualStock",nullable = false)
	private int actualStock;
	
	@Autowired
	@Column(name = "minimumQuantity",nullable = false)
	private int minimumQuantity;

	public Case getKase() {
		return kase;
	}

	public void setKase(Case kase) {
		this.kase = kase;
	}

	public int getActualStock() {
		return actualStock;
	}

	public void setActualStock(int actualStock) {
		this.actualStock = actualStock;
	}

	public int getMinimumQuantity() {
		return minimumQuantity;
	}

	public void setMinimumQuantity(int minimumQuantity) {
		this.minimumQuantity = minimumQuantity;
	}

}
