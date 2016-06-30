package ilan.dtos;

import java.util.Date;
import java.util.HashMap;

import org.thymeleaf.util.Validate;

public class CaseOrderDTO {
	private Long id;
	private HashMap<CaseProductDTO,Integer> requestCases;
	private Date dateOfRequest, dateOfDelivery;
	
	public CaseOrderDTO(){}
	
	public CaseOrderDTO(HashMap<CaseProductDTO,Integer> requestCases, Date dateOfRequest) {
		super();
		Validate.notNull(dateOfRequest, "Date of request cannot be null");
		Validate.notNull(requestCases, "Request cases cannot be null");
		Validate.containsNoEmpties((Iterable<String>) requestCases, "There must be at least 1 request case");
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

	public HashMap<CaseProductDTO, Integer> getRequestCases() {
		return requestCases;
	}

	public void setRequestCases(HashMap<CaseProductDTO, Integer> requestCases) {
		this.requestCases = requestCases;
	}

	
}
