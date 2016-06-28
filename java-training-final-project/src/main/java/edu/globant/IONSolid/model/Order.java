package edu.globant.IONSolid.model;

import java.util.List;

import edu.globant.IONSolid.model.cases.CaseItem;
import edu.globant.IONSolid.model.delivery.Delivery;
import edu.globant.IONSolid.model.provider.Provider;

public class Order {

	private String orderId;
	private Provider orderProvider;
	private Delivery orderDelivery;
	private List<CaseItem> orderItems;
	
	public Order(String orderId, Provider orderProvider, List<CaseItem> orderItems) {
		this.orderId = orderId;
		this.orderProvider = orderProvider;
		this.orderItems = orderItems;
	}

	public Delivery addOrderDelivery() {
		return orderDelivery;
	}

	public void setOrderDelivery(Delivery orderDelivery) {
		this.orderDelivery = orderDelivery;
	}

	public String getOrderId() {
		return orderId;
	}

	public Provider getOrderProvider() {
		return orderProvider;
	}

	public List<CaseItem> getOrderItems() {
		return orderItems;
	}
	

}
