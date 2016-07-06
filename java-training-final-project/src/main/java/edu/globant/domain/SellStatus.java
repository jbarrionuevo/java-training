package edu.globant.domain;

import java.util.Date;

public abstract class SellStatus{
	private Date date;
	//types: RefundSell / DraftSell / Complete
	private String type;
	private String description;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
