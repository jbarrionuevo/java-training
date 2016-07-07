package edu.globant.finalproject.hibernate;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;

import edu.globant.finalproject.model.Case.CaseDTO;
import edu.globant.finalproject.model.Provider.ProviderDTO;

@Entity
@Table(name = "order")
public class Order extends BaseEntity implements Serializable{
	
	public Order() {}
	
	@Autowired
	@Column(name = "number", nullable = false, length=6)
	private int number;
	
	@Autowired
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idProvider")
	private Provider provider;
	
	
	//private ArrayList<CaseCoverage> cases;
}
