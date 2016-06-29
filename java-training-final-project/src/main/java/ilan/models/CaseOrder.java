package ilan.models;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import org.thymeleaf.util.Validate;

@Entity
@Table(indexes = {@Index(columnList = "dateOfRequest", name = "case_order_date_of_request"),
				  @Index(columnList = "dateOfDelivery", name = "case_order_date_of_delivery")})
public class CaseOrder {
	@Id
	@GeneratedValue
	private Long id;
	
	private HashMap<CaseProduct,Integer> requestCases;
	private Date dateOfRequest, dateOfDelivery;
	
	public CaseOrder(){}
	
	public CaseOrder(HashMap<CaseProduct,Integer> requestCases, Date dateOfRequest) {
		super();
		Validate.notNull(dateOfRequest, "Date of request cannot be null");
		Validate.notNull(requestCases, "Request cases cannot be null");
		Validate.containsNoEmpties((Iterable<String>) requestCases, "There must be at least 1 request case");
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

	@Override
	public String toString(){
		String items = "";
		for (Map.Entry<CaseProduct, Integer> entry : this.getRequestCases().entrySet()) {
			items = items.concat(entry.getValue()+" items of "+entry.getKey()+"\n");
		}
		return String.format("Date of request: %s. \nOrder: \n%s", 
				this.getDateOfRequest(),items );
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

	public HashMap<CaseProduct,Integer> getRequestCases() {
		return requestCases;
	}

	public void setRequestCases(HashMap<CaseProduct,Integer> requestCases) {
		this.requestCases = requestCases;
	}
	
}
