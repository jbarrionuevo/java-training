package edu.globant.finalproject.hibernate;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "case_stock")
public class CaseStock extends BaseEntity implements Serializable{
	
	public CaseStock() {}
	
	@Autowired
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "caseStock", cascade = CascadeType.ALL)
	private CaseCoverage kase;
	
	@Autowired
	@Column(name = "actualStock",nullable = false)
	private int actualStock;
	
	@Autowired
	@Column(name = "minimumQuantity",nullable = false)
	private int minimumQuantity;

	public CaseCoverage getKase() {
		return kase;
	}

	public void setKase(CaseCoverage kase) {
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
