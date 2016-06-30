package ilan.dtos;

import java.util.Date;
import java.util.HashMap;

import org.thymeleaf.util.Validate;

public class CaseOrderDTO {
	private Long id;
	private HashMap<Integer,CaseProductDTO> requestCases;
	private Date dateOfRequest, dateOfDelivery;
	
	public CaseOrderDTO(){}
	
	public CaseOrderDTO(HashMap<Integer,CaseProductDTO> requestCases, Date dateOfRequest) {
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

	public HashMap<Integer,CaseProductDTO> getRequestCases() {
		return requestCases;
	}

	public void setRequestCases(HashMap<Integer,CaseProductDTO> requestCases) {
		this.requestCases = requestCases;
	}

	
}
