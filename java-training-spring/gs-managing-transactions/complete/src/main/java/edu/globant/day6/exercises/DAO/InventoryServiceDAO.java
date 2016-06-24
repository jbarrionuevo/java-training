package edu.globant.day6.exercises.DAO;

import org.springframework.data.repository.CrudRepository;

import edu.globant.day6.exercises.model.Inventory;

public interface InventoryServiceDAO extends CrudRepository<Inventory, Long> {

}
