package edu.globant.IONSolid.model.order;

import java.util.Date;
import java.util.List;

import edu.globant.IONSolid.model.productcases.ProductCase;
import edu.globant.IONSolid.model.provider.Provider;

public class Order {

	private Long orderId;
	private Double total;
	private Provider orderProvider;
	private List<ProductCase> orderItems;
	OrderState orderState;
	Date expectedDeliveredDate;
	Date orderCreatedDate;
	
	public Order(Long orderId, Provider orderProvider, List<ProductCase> orderItems) {
		this.orderId = orderId;
		this.orderProvider = orderProvider;
		this.orderItems = orderItems;
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

	public OrderState getOrderState() {
		return orderState;
	}

	public void setOrderState(OrderState orderState) {
		this.orderState = orderState;
	}

	public Date getExpectedDeliveredDate() {
		return expectedDeliveredDate;
	}

	public void setExpectedDeliveredDate(Date expectedDeliveredDate) {
		this.expectedDeliveredDate = expectedDeliveredDate;
	}

	public Double getTotal() {
		return total;
	}

	public Date getOrderCreatedDate() {
		return orderCreatedDate;
	}
}
