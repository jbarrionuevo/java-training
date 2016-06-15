package edu.globant.day1.exercises.designPatterns.model;

import java.util.HashSet;
import java.util.Set;

import org.joda.time.LocalDate;

public class Order {

	private int id;
	private LocalDate deliveryDate;
	private int delayFromSchedule;
	private String orderStatus = OrderStatusEnum.ORDERED.getOrderStatus();
	private Set<OrderDetail> orderDetails = new HashSet<OrderDetail>();
	private CaseProvider caseProvider;
	
	public Order(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Set<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public CaseProvider getCaseProvider() {
		return caseProvider;
	}

	public void setCaseProvider(CaseProvider caseProvider) {
		this.caseProvider = caseProvider;
	}
	
	public int getDelayFromSchedule() {
		return delayFromSchedule;
	}

	public void setDelayFromSchedule(int delayFromSchedule) {
		this.delayFromSchedule = delayFromSchedule;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", deliveryDate=" + deliveryDate + ", delayFromSchedule=" + delayFromSchedule
				+ ", orderStatus=" + orderStatus + ", orderDetails=" + orderDetails + ", caseProvider=" + caseProvider
				+ "]";
	}
	
}
