package ilan.models;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.thymeleaf.util.Validate;

@Entity
@Table(indexes = {@Index(columnList = "dateOfRequest", name = "case_order_date_of_request"),
				  @Index(columnList = "dateOfDelivery", name = "case_order_date_of_delivery")})
public class CaseOrder {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(columnDefinition = "LONGBLOB")
	private HashMap<Long,Integer> requestCases;
	private Date dateOfRequest, dateOfDelivery;
	
	@ManyToOne
	private ThirdPartyParticipant thirdPartyParticipant;
	
	
	public CaseOrder(){}
	
	public CaseOrder(HashMap<Long,Integer> requestCases, Date dateOfRequest, ThirdPartyParticipant thirdPartyParticipant) {
		super();
		Validate.notNull(dateOfRequest, "Date of request cannot be null");
		Validate.notNull(requestCases, "Request cases cannot be null");
//		Validate.containsNoEmpties((Iterable<String>) requestCases, "There must be at least 1 request case");
		this.requestCases = requestCases;
		this.dateOfRequest=dateOfRequest;
		this.thirdPartyParticipant=thirdPartyParticipant;
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
		for (Map.Entry<Long, Integer> entry : this.getRequestCases().entrySet()) {
			items = items.concat(entry.getValue()+" items of product with id "+entry.getKey()+"\n");
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

	public HashMap<Long,Integer> getRequestCases() {
		return requestCases;
	}

	public void setRequestCases(HashMap<Long,Integer> requestCases) {
		this.requestCases = requestCases;
	}

	public ThirdPartyParticipant getThirdPartyParticipant() {
		return thirdPartyParticipant;
	}

	public void setThirdPartyParticipant(ThirdPartyParticipant thirdPartyParticipant) {
		this.thirdPartyParticipant = thirdPartyParticipant;
	}

	
}
