package edu.globant.finalproject.hibernate;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.Validate;

import edu.globant.finalproject.model.Case.DesignDTO;
import edu.globant.finalproject.model.Case.DeviceDTO;

@Entity
@Table(name = "Case")
public class Case extends BaseEntity implements Serializable{
	
	private Case(){}
	
	public Case(String name,String code,ArrayList<Device> devices, Design design, double price) {
		
		Validate.notBlank(name,"The name cannot be blank");
		Validate.notBlank(code,"The name cannot be blank");
		Validate.notEmpty(devices,"It must have at least one device");
		Validate.notNull(design,"The design cannot be null");
		Validate.notNull(price,"The price cannot be null");
		
		this.name = name;
		this.code = code;
		this.devices = devices;
		this.design = design;
		this.price = price;
	}
	
	@Column(name = "name", length=20)
	private String name;
	
	@Column(name = "code", length=8,nullable=false)
	private String code;
	
	@ManyToOne(optional=false)
	@JoinColumn(name = "provider", insertable=true, updatable=false)
	private Provider provider;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "case_device", joinColumns = { 
			@JoinColumn(name = "case_id", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "device_id", 
					nullable = false, updatable = false) })
	private ArrayList<Device> devices;
	
	@OneToOne (cascade=CascadeType.ALL)
	  @JoinColumn(name="design_id", nullable=false, insertable=true, updatable=true)
	private Design design;
	
	@Column(name = "price", length=6,nullable=false)
	private double price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public ArrayList<Device> getDevices() {
		return devices;
	}

	public void setDevices(ArrayList<Device> devices) {
		this.devices = devices;
	}

	public Design getDesign() {
		return design;
	}

	public void setDesign(Design design) {
		this.design = design;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
