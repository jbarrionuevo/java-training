package ilan.dtos;

import java.util.Date;
import java.util.HashMap;


import org.thymeleaf.util.Validate;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CaseOrderDTO {
	private Long id;
	private HashMap<String,Integer> requestCases;
	private Date dateOfRequest, dateOfDelivery;
	
	@JsonCreator
	public CaseOrderDTO(){}
	
	@JsonCreator
	public CaseOrderDTO(@JsonProperty("requestCases") HashMap<String,Integer> requestCases, 
			@JsonProperty("dateOfRequest") Date dateOfRequest) {
		super();
		this.requestCases = requestCases;
		this.dateOfRequest=dateOfRequest;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public HashMap<String,Integer> getRequestCases() {
		return requestCases;
	}

	public void setRequestCases(HashMap<String,Integer> requestCases) {
		this.requestCases = requestCases;
	}

	
}
