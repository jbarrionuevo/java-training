package edu.globant.day1.ddd.exercices.models;

import java.util.Date;
import java.util.HashMap;

import org.joda.time.DateTime;
import org.joda.time.Days;

public class CaseOrder {
	private HashMap<Case,Integer> requestCases;
	private Date dateOfRequest, dateOfDelivery;
	private int id;
	
	public CaseOrder(){}
	
	public CaseOrder(HashMap<Case,Integer> requestCases, Date dateOfRequest) {
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

	public HashMap<Case,Integer> getRequestCases() {
		return requestCases;
	}

	public void setRequestCases(HashMap<Case,Integer> requestCases) {
		this.requestCases = requestCases;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
