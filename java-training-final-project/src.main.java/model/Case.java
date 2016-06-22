package model;

import java.util.Date;

public abstract class Case {
	public String name;

	// lowest stock accepted
	public int watermark = 0;

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

	public abstract int getStock();

	public abstract int getWatermark();

	public abstract int setWatermark();

	public abstract Date getOrderExpected();

	public abstract void setOrderExpected(Date orderExpected);

	public abstract Date getOrderDelivered();

	public abstract void setOrderDelivered(Date orderDelivered);

	public abstract int getProvider();

	public abstract Provider setProvider();

}
