package edu.globant.day6.exercises.DAO;

import org.springframework.data.repository.CrudRepository;

import edu.globant.day6.exercises.model.Provider;

public interface ProviderServiceDAO extends CrudRepository<Provider, Long> {

}
