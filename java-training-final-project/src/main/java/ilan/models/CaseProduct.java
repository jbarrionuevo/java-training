package ilan.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.thymeleaf.util.Validate;

@Entity
public class CaseProduct implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	private CaseDesign design;
	@ManyToOne
	private CaseDevice device;
	private double price;
	@ManyToOne
	private Provider provider;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "product", cascade = CascadeType.ALL)
	private Collection<OrderAlert> alerts;
	
	public CaseProduct(){}
	
	public CaseProduct(CaseDesign design, CaseDevice device, Double price, Provider provider) {
		Validate.notNull(design, "Design cannot be null");
		Validate.notNull(device,"Device cannot be null");
		Validate.notNull(provider,"Provider cannot be null");
		Validate.notNull(price,"Price cannot be null");
		this.design = design;
		this.device = device;
		this.price=price;
		this.provider=provider;
	}
	
	@Override
	public String toString(){
		return String.format("Design: %s, Device: %s, Provider: %s", 
				this.getDesign().getName(), this.getDevice().getName(), this.getProvider().getName()+"("+this.getProvider().getLocation()+")");
	}
	
	@Override
	public boolean equals(Object otherCaseProduct){
		CaseProduct other = (CaseProduct)otherCaseProduct;
		return this.getDesign().equals(other.getDesign())
				&& (this.getDevice().equals(other.getDevice()))
				&& (this.getProvider().equals(other.getProvider()));
	}
	
	public CaseDesign getDesign() {
		return design;
	}
	public void setDesign(CaseDesign design) {
		this.design = design;
	}
	public CaseDevice getDevice() {
		return device;
	}
	public void setDevice(CaseDevice device) {
		this.device = device;
	}


	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Collection<OrderAlert> getAlerts() {
		return alerts;
	}

	public void setAlerts(Collection<OrderAlert> alerts) {
		this.alerts = alerts;
	}
	
	
}
