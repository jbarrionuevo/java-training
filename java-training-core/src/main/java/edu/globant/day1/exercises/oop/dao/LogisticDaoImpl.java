package edu.globant.day1.exercises.oop.dao;

import java.util.Set;

import edu.globant.day1.exercises.oop.model.Alert;
import edu.globant.day1.exercises.oop.model.Logistic;
import edu.globant.day1.exercises.oop.model.Order;

public class LogisticDaoImpl implements LogisticDao {

	@Override
	public Logistic getLogistic(int id) {
		// Gets a Logistic Employe from the DB based on the Id
		return null;
	}

	@Override
	public void saveLogistic(Logistic logistic) {
		// Persists a Logistic Employee in the DB
		
	}

	@Override
	public void deleteLogistic(Logistic logistic) {
		// Deletes a Logistic Employe from the DB
		
	}

	@Override
	public void deleteAlert(Alert alert) {
		// Allows a Logistic Employee to delete an Alert from the DB
		
	}

	@Override
	public Order getOrder(int id) {
		// Gets a single Order from the DB based on the Id
		return null;
	}

	@Override
	public void saveOrder(Order order) {
		// Persists an Order in the DB
		
	}

	@Override
	public void deleteOrder(Order order) {
		// Deletes an Order from the DB
		
	}

	@Override
	public Set<Order> getAllOrders() {
		// Gets all orders from the DB
		return null;
	}

	@Override
	public Set<Order> getOrdersByLogistic(int id) {
		// Gets a single Logistic Employee orders based on the Employee's id.
		return null;
	}

	@Override
	public Set<Order> getOrdersByProvider(int id) {
		// Gets all orders from a single Provider based on the Provider's id.
		return null;
	}

}
