package edu.globant.day6.exercises.DAO;

import org.springframework.data.repository.CrudRepository;

import edu.globant.day6.exercises.model.Sale;

public interface SaleServiceDAO extends CrudRepository<Sale, Long> {

}
