package model;

import java.util.Date;

public class CaseImpl extends Case {

	public String caseDesign;
	public String caseDevice;

	public CaseImpl(String caseDesign, String caseDevice) {
		this.caseDesign = caseDesign;
	}

	public Date orderExpected() {
		// TODO Auto-generated method stub
		return null;
	}

	public Date orderDelivered() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getStock() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getWatermark() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int setWatermark() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Date getOrderExpected() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setOrderExpected(Date orderExpected) {
		// TODO Auto-generated method stub

	}

	public Date getOrderDelivered() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setOrderDelivered(Date orderDelivered) {
		// TODO Auto-generated method stub

	}

	public Provider provider() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getProvider() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Provider setProvider() {
		// TODO Auto-generated method stub
		return null;
	}
}