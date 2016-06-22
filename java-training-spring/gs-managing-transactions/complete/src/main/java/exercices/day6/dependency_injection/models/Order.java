package exercices.day6.dependency_injection.models;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Order {
	@Id
	@GeneratedValue
	private Long id;
	private HashMap<Case,Integer> requestCases;
	private Date dateOfRequest, dateOfDelivery;
	
	public Order(){}
	
	public Order(HashMap<Case,Integer> requestCases, Date dateOfRequest) {
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

	@Override
	public String toString(){
		String items = "";
		for (Map.Entry<Case, Integer> entry : this.getRequestCases().entrySet()) {
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

	public HashMap<Case,Integer> getRequestCases() {
		return requestCases;
	}

	public void setRequestCases(HashMap<Case,Integer> requestCases) {
		this.requestCases = requestCases;
	}
	
}
