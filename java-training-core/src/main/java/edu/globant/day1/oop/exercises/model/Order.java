package edu.globant.day1.oop.exercises.model;

import java.util.Date;
import java.util.HashMap;

public class Order {

	private HashMap<Case, Integer> Cases;
	private Date requestDate;
	private Date receivedDate;

	public Date getDeliveryDate() {
		return requestDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.requestDate = deliveryDate;
	}

	public HashMap<Case, Integer> getCases() {
		return Cases;
	}

	public void setCases(HashMap<Case, Integer> cases) {
		Cases = cases;
	}

	public Date getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(Date receivedDate) {
		this.receivedDate = receivedDate;
	}

}
