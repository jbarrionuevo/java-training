package edu.globant.day1.oop.exercises.model;

import java.sql.Date;
import java.util.ArrayList;

import edu.globant.day1.oop.exercises.model.cases.Case;
import edu.globant.day1.oop.exercises.model.provider.Provider;

public class Delivery {

	private Provider provider;
	private Date deliverDate;
	//true delay, false not delay
	//could be an enum
	private boolean status; 
	private ArrayList<Case> cases;
	
	public Delivery(Provider provider, Date date) {
		this.setProvider(provider);
		this.setDeliverDate(date);
		this.setStatus(false); //false by defect
	}
	
	public void addCases(Case newCase) {
		if(this.getDeliveryAmount() + 1 < this.getDeliveryAmount()) {
			this.cases.add(newCase);
		} else {
			//throw exception
		}
	}
	
	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public int getDeliveryAmount() {
		return this.cases.size();
	}


	public Date getDeliverDate() {
		return deliverDate;
	}

	public void setDeliverDate(Date deliverDate) {
		this.deliverDate = deliverDate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
