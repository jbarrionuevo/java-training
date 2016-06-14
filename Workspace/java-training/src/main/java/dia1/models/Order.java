package dia1.models;

import java.util.Date;
import java.util.HashMap;

import org.joda.time.DateTime;
import org.joda.time.Days;

import dia1.auxiliary_classes.DateMethods;

public abstract class Order {
	private HashMap<Case,Integer> requestCases;
	private Date dateOfRequest, dateOfDelivery;
	private ThirdPartyParticipant creator;
	
	public Order(){}
	
	public Order(HashMap<Case,Integer> requestCases, Date dateOfRequest, ThirdPartyParticipant creator) {
		super();
		this.requestCases = requestCases;
		this.dateOfRequest=dateOfRequest;
		this.creator=creator;
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

	public ThirdPartyParticipant getCreator() {
		return creator;
	}

	public void setCreator(ThirdPartyParticipant creator) {
		this.creator = creator;
	}

	public HashMap<Case,Integer> getRequestCases() {
		return requestCases;
	}

	public void setRequestCases(HashMap<Case,Integer> requestCases) {
		this.requestCases = requestCases;
	}
	
}
