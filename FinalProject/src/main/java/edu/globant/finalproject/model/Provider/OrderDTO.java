package edu.globant.finalproject.model.Provider;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.Validate;

import edu.globant.finalproject.hibernate.BaseEntity;
import edu.globant.finalproject.model.Case.CaseDTO;


public class OrderDTO{

	//TODO:deberia ser autogenerado incremental 6 digitos
	private int number;
	//TODO:deberia autoasignarse cuando la orden se la asigna a un proveedor 
	private ProviderDTO provider;
	private ArrayList<CaseDTO> cases;
	
	public OrderDTO(ProviderDTO p){
		Validate.notNull(p,"provider cannot be null");
		
		this.provider = p;
	}
	
	public OrderDTO(ArrayList<CaseDTO> cases){
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

	public ProviderDTO getProvider() {
		return provider;
	}

	public void setProvider(ProviderDTO provider) {
		this.provider = provider;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public ArrayList<CaseDTO> getCases() {
		return cases;
	}

	public void setCases(ArrayList<CaseDTO> cases) {
		this.cases = cases;
	}
	
	
	
	
}
