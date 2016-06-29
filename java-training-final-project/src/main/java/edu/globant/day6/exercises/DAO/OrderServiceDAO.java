package edu.globant.day6.exercises.DAO;

import org.springframework.data.repository.CrudRepository;

import edu.globant.day6.exercises.model.Order;

public interface OrderServiceDAO extends CrudRepository<Order, Long>{

}
