package edu.globant.day1.multi_tier_applications.exercices.layers.services;

import edu.globant.day1.oop.exercices.auxiliary_classes.DateMethods;
import edu.globant.day1.oop.exercices.daos.OrderDao;
import edu.globant.day1.oop.exercices.models.Order;

public class OrderService {
	
	private OrderDao orderDao;
	
	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
}
