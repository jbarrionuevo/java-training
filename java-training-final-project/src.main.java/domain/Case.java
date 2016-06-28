package domain;

import java.util.Date;
import java.util.List;

import persistence.DAO.DTO;

public class Case implements DTO {

	private String ID;

	private List<Device> supportedDevices;

	private int waterMark;

	public Date orderExpected() {
		return null;
	}

	public Date orderDelivered() {
		return null;
	}

	public Provider provider() {
		return null;
	}

	// define static interface to keep track of stock
	public static int unitsInStock = 0;

	public static void addToStock(int unitsToAdd) {
	}

	public static void removeFromStock(int unitsToRemove) {
	}

	public String getID() {
		return ID;
	}

	public int getStock() {
		return 0;
	}

	public int getWatermark() {
		return 0;
	}

	public void setWatermark(int watermark) {
	}

	public Date getOrderExpected() {
		return null;
	}

	public void setOrderExpected(Date orderExpected) {
	}

	public Date getOrderDelivered() {
		return null;
	}

	public void setOrderDelivered(Date orderDelivered) {
	}

	public int getProvider() {
		return 0;
	}

	public Provider setProvider() {
		return null;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public List<Device> getSupportedDevices() {
		return supportedDevices;
	}

	public void setSupportedDevices(List<Device> supportedDevices) {
		this.supportedDevices = supportedDevices;
	}

	public int getWaterMark() {
		return waterMark;
	}

	public void setWaterMark(int waterMark) {
		this.waterMark = waterMark;
	}
}
