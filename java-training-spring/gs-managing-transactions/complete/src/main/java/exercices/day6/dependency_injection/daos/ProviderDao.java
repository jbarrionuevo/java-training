package exercices.day6.dependency_injection.daos;

import org.springframework.data.repository.CrudRepository;

import exercices.day6.dependency_injection.Provider;

public interface ProviderDao extends CrudRepository<Provider,Long>{

}
