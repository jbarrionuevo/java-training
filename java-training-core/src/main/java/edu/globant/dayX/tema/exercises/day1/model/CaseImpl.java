package edu.globant.dayX.tema.exercises.day1.model;

import java.util.Date;

public class CaseImpl implements Case {

	public String caseDesign;
	public String caseDevice;

	public CaseImpl(String caseDesign, String caseDevice) {
		this.caseDesign = caseDesign;
	}

	@Override
	public Date orderExpected() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date orderDelivered() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getStock() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getWatermark() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setWatermark() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Date getOrderExpected() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setOrderExpected(Date orderExpected) {
		// TODO Auto-generated method stub

	}

	@Override
	public Date getOrderDelivered() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setOrderDelivered(Date orderDelivered) {
		// TODO Auto-generated method stub

	}

	@Override
	public Provider provider() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getProvider() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Provider setProvider() {
		// TODO Auto-generated method stub
		return null;
	}

}
