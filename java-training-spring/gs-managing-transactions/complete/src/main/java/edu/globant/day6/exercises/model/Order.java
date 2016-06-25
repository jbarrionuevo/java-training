package edu.globant.day6.exercises.model;

import java.util.Date;
import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import edu.globant.day6.exercises.model.Case;

@Entity
public class Order {

	@Id
	@GeneratedValue
	private Long id;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
