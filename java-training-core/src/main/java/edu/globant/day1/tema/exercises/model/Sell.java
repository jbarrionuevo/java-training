package edu.globant.day1.tema.exercises.model;

import java.util.ArrayList;
import java.util.List;

public interface Sell {
	public float value = 0.0f;
	public List<Case> products = new ArrayList<Case>();
	public Seller seller = new Seller();

	// status possible values: draft, paid, cancelled or refund
	public String status = "";

	// description of the status
	public String statusDescription = "";

	public void setValue(float value);

	public float getValue();

	public void setStatus();

	public float getStatus();

	public void setStatusDescription();

	public float getStatusDescription();

	public void setSeller();

	public float getSeller();

}
