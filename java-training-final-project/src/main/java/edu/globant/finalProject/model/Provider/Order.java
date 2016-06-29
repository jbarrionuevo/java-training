package edu.globant.finalProject.model.Provider;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.Validate;

import edu.globant.finalProject.hibernate.BaseEntity;
import edu.globant.finalProject.model.Case.Case;

public class Order extends BaseEntity{

	//TODO:deberia ser autogenerado incremental 6 digitos
	private int number;
	//TODO:deberia autoasignarse cuando la orden se la asigna a un proveedor 
	private Provider provider;
	private ArrayList<Case> cases;
	
	public Order(Provider p){
		Validate.notNull(p,"provider cannot be null");
		
		this.provider = p;
	}
	
	public Order(ArrayList<Case> cases){
		Validate.notNull(cases,"cases cannot be null");
		Validate.notEmpty(cases,"cases cannot be empty");
		
		this.cases = cases;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public ArrayList<Case> getCases() {
		return cases;
	}

	public void setCases(ArrayList<Case> cases) {
		this.cases = cases;
	}
	
	
	
	
}
