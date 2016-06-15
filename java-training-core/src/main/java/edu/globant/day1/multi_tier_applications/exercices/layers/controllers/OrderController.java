package edu.globant.day1.multi_tier_applications.exercices.layers.controllers;

import edu.globant.day1.multi_tier_applications.exercices.layers.services.OrderService;

public class OrderController {
	private OrderService orderService;

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
}
