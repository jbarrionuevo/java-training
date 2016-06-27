package edu.globant.com.javaFinalProject.service;

import java.util.Set;

import edu.globant.com.javaFinalProject.dao.LogisticDao;
import edu.globant.com.javaFinalProject.model.Alert;
import edu.globant.com.javaFinalProject.model.Logistic;
import edu.globant.com.javaFinalProject.model.Order;


public class LogisticServiceImpl implements LogisticService {

	LogisticDao dao;
	
	public Logistic getLogistic(int id) {
		return dao.getLogistic(id);
	}

	public void saveLogistic(Logistic logistic) {
		dao.saveLogistic(logistic);	
	}

	public void updateLogistic(Logistic logistic) {
		Logistic entity = dao.getLogistic(logistic.getId());
		if(entity!=null){
			//Updates logistic employee data
		}
	}
	
	public void deleteLogistic(Logistic logistic) {
		dao.deleteLogistic(logistic);		
	}

	public void deleteAlert(Alert alert) {
		dao.deleteAlert(alert);	
	}

	public Order getOrder(int id) {
		return dao.getOrder(id);
	}

	public void saveOrder(Order order) {
		dao.saveOrder(order);	
	}

	public void updateOrder(Order order) {
		Order entity = dao.getOrder(order.getId());
		if(entity!=null){
			//updates order data
			//If order status is DELIVERED, it increases the stock for the cases specified in OrderDetails
		}
		
	}

	public void deleteOrder(Order order) {
		dao.deleteOrder(order);	
	}

	public Set<Order> getAllOrders() {
		return dao.getAllOrders();
	}

	public Set<Order> getOrdersByLogistic(int id) {
		return dao.getOrdersByLogistic(id);
	}

	public Set<Order> getOrdersByProvider(int id) {
		return dao.getOrdersByProvider(id);
	}

}
