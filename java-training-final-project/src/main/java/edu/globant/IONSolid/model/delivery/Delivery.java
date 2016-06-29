package edu.globant.IONSolid.model.delivery;

import java.sql.Date;
import java.util.ArrayList;

import edu.globant.IONSolid.model.cases.CaseModel;
import edu.globant.IONSolid.model.provider.Provider;

public class Delivery {

	private Provider provider;
	private Date deliverDate;
	private DeliveryStatus status; 
	private ArrayList<CaseModel> cases;
	
	public Delivery(Provider provider, Date date) {
		this.setProvider(provider);
		this.setDeliverDate(date);
		//ON_DATE by defect
		this.setStatus(DeliveryStatus.ON_DATE); 
	}
	
	public void addCases(CaseModel newCase) {
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

	public DeliveryStatus isStatus() {
		return status;
	}

	public void setStatus(DeliveryStatus status) {
		this.status = status;
	}
}
