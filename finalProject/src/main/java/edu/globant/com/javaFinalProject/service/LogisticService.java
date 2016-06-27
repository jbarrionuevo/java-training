package edu.globant.com.javaFinalProject.service;

import java.util.Set;

import edu.globant.com.javaFinalProject.model.Alert;
import edu.globant.com.javaFinalProject.model.Logistic;
import edu.globant.com.javaFinalProject.model.Order;


public interface LogisticService {
	
	Logistic getLogistic(int id);
	void saveLogistic(Logistic logistic);
	void updateLogistic(Logistic logistic);
	void deleteLogistic(Logistic logistic);
	void deleteAlert(Alert alert);
	Order getOrder(int id);
	void saveOrder(Order order);
	void updateOrder(Order order);
	void deleteOrder(Order order);
	Set<Order> getAllOrders();
	Set<Order> getOrdersByLogistic(int id);
	Set<Order> getOrdersByProvider(int id);
	
}
