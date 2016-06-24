package edu.globant.day6.exercises.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.globant.day6.exercises.model.Case;

@Repository
public interface CaseDAO extends CrudRepository<Case, Long> {

}
