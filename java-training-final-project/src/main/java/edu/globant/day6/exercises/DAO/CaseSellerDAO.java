package edu.globant.day6.exercises.DAO;

import org.springframework.data.repository.CrudRepository;

import edu.globant.day6.exercises.model.CaseSellers;

public interface CaseSellerDAO extends CrudRepository<CaseSellers, Long> {

}
