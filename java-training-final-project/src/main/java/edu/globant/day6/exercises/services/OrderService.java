package edu.globant.day6.exercises.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.globant.day6.exercises.DAO.OrderServiceDAO;


@Service
public class OrderService {
	
	@Autowired
	OrderServiceDAO orderServiceDAO;

	public OrderServiceDAO getOrderServiceDAO() {
		return orderServiceDAO;
	}

	public void setOrderServiceDAO(OrderServiceDAO orderServiceDAO) {
		this.orderServiceDAO = orderServiceDAO;
	}

}
