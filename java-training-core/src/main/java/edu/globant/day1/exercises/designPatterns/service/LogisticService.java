package edu.globant.day1.exercises.designPatterns.service;

import java.util.Set;

import edu.globant.day1.exercises.oop.model.Logistic;
import edu.globant.day1.exercises.oop.model.Order;
import edu.globant.day1.exercises.oop.model.Alert;

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
