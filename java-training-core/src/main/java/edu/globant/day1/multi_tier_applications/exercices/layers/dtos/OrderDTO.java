package edu.globant.day1.multi_tier_applications.exercices.layers.dtos;

import java.util.Date;
import java.util.HashMap;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.joda.time.DateTime;
import org.joda.time.Days;

public abstract class OrderDTO {
	@Valid
	private HashMap<CaseDTO,Integer> requestCases;
	
	@NotNull
	private Date dateOfRequest;
	
	private Date dateOfDelivery;
	
	public OrderDTO(){}
	
	public OrderDTO(HashMap<CaseDTO,Integer> requestCases, Date dateOfRequest) {
		super();
		this.requestCases = requestCases;
		this.dateOfRequest=dateOfRequest;
	}
	
	public int getQuantity(){
		int result=0;
		for (Integer value : this.getRequestCases().values()) {
		    result+=value;
		}
		return result;
	}

	public Date getDateOfRequest() {
		return dateOfRequest;
	}

	public void setDateOfRequest(Date dateOfRequest) {
		this.dateOfRequest = dateOfRequest;
	}

	public Date getDateOfDelivery() {
		return dateOfDelivery;
	}

	public void setDateOfDelivery(Date dateOfDelivery) {
		this.dateOfDelivery = dateOfDelivery;
	}

	public HashMap<CaseDTO,Integer> getRequestCases() {
		return requestCases;
	}

	public void setRequestCases(HashMap<CaseDTO,Integer> requestCases) {
		this.requestCases = requestCases;
	}
	
}
