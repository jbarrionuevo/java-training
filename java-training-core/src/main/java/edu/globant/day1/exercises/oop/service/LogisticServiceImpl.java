package edu.globant.day1.exercises.oop.service;

import java.util.Set;

import edu.globant.day1.exercises.oop.dao.LogisticDao;
import edu.globant.day1.exercises.oop.model.Alert;
import edu.globant.day1.exercises.oop.model.Logistic;
import edu.globant.day1.exercises.oop.model.Order;

public class LogisticServiceImpl implements LogisticService {

	LogisticDao dao;
	
	@Override
	public Logistic getLogistic(int id) {
		return dao.getLogistic(id);
	}

	@Override
	public void saveLogistic(Logistic logistic) {
		dao.saveLogistic(logistic);	
	}

	@Override
	public void updateLogistic(Logistic logistic) {
		Logistic entity = dao.getLogistic(logistic.getId());
		if(entity!=null){
			//Updates logistic employee data
		}
	}

	@Override
	public void deleteLogistic(Logistic logistic) {
		dao.deleteLogistic(logistic);		
	}

	@Override
	public void deleteAlert(Alert alert) {
		dao.deleteAlert(alert);	
	}

	@Override
	public Order getOrder(int id) {
		return dao.getOrder(id);
	}

	@Override
	public void saveOrder(Order order) {
		dao.saveOrder(order);	
	}

	@Override
	public void updateOrder(Order order) {
		Order entity = dao.getOrder(order.getId());
		if(entity!=null){
			//updates order data
			//If order status is DELIVERED, it increases the stock for the cases specified in OrderDetails
		}
		
	}

	@Override
	public void deleteOrder(Order order) {
		dao.deleteOrder(order);	
	}

	@Override
	public Set<Order> getAllOrders() {
		return dao.getAllOrders();
	}

	@Override
	public Set<Order> getOrdersByLogistic(int id) {
		return dao.getOrdersByLogistic(id);
	}

	@Override
	public Set<Order> getOrdersByProvider(int id) {
		return dao.getOrdersByProvider(id);
	}

}
