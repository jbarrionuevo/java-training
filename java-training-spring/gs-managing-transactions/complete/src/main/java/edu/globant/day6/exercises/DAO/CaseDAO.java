package edu.globant.day6.exercises.DAO;

import org.springframework.data.repository.CrudRepository;

import edu.globant.day6.exercises.model.Case;

public interface CaseDAO extends CrudRepository<Case, Long> {

}
