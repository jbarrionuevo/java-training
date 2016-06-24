package edu.globant.day6.exercises.DAO;

import org.springframework.data.repository.CrudRepository;

import edu.globant.day6.exercises.model.Design;

public interface DesignDAO extends CrudRepository<Design, Long> {

}
