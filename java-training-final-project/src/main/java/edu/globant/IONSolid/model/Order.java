package edu.globant.IONSolid.model;

import java.util.List;

import edu.globant.IONSolid.model.cases.ProductCase;
import edu.globant.IONSolid.model.delivery.Delivery;
import edu.globant.IONSolid.model.provider.Provider;

public class Order {

	private Long orderId;
	private Provider orderProvider;
	private Delivery orderDelivery;
	private List<ProductCase> orderItems;
	private Double price;
	
	public Order(Long orderId, Provider orderProvider, List<ProductCase> orderItems) {
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

	public Long getOrderId() {
		return orderId;
	}

	public Provider getOrderProvider() {
		return orderProvider;
	}

	public List<ProductCase> getOrderItems() {
		return orderItems;
	}
}
