package edu.globant.com.javaFinalProject.dao;

import java.util.Set;

import edu.globant.com.javaFinalProject.model.Alert;
import edu.globant.com.javaFinalProject.model.Logistic;
import edu.globant.com.javaFinalProject.model.Order;

public class LogisticDaoImpl implements LogisticDao {

	public Logistic getLogistic(int id) {
		// Gets a Logistic Employe from the DB based on the Id
		return null;
	}

	public void saveLogistic(Logistic logistic) {
		// Persists a Logistic Employee in the DB
		
	}

	public void deleteLogistic(Logistic logistic) {
		// Deletes a Logistic Employe from the DB
		
	}

	public void deleteAlert(Alert alert) {
		// Allows a Logistic Employee to delete an Alert from the DB
		
	}

	public Order getOrder(int id) {
		// Gets a single Order from the DB based on the Id
		return null;
	}

	public void saveOrder(Order order) {
		// Persists an Order in the DB
		
	}

	public void deleteOrder(Order order) {
		// Deletes an Order from the DB
		
	}

	public Set<Order> getAllOrders() {
		// Gets all orders from the DB
		return null;
	}

	public Set<Order> getOrdersByLogistic(int id) {
		// Gets a single Logistic Employee orders based on the Employee's id.
		return null;
	}

	public Set<Order> getOrdersByProvider(int id) {
		// Gets all orders from a single Provider based on the Provider's id.
		return null;
	}

}
