package edu.globant.dayX.tema.exercises.day1.model;

import java.util.Date;

public interface Case {
	public String name = "";	
	
	//lowest stock accepted
	public int watermark = 0;
	public Date orderExpected();
	public Date orderDelivered();
	
	//define static interface to keep track of stock
	public static int stock = 0;
	
	public static void addToStock(int unitsToAdd) {
	}
	
	public static void removeFromStock(int unitsToRemove) {
	}
	
	public int getStock();
	
	public int getWatermark();

	public int setWatermark();
	
	public Date getOrderExpected();
	
	public void setOrderExpected(Date orderExpected);
	
	public Date getOrderDelivered();
	
	public void setOrderDelivered(Date orderDelivered);
}
