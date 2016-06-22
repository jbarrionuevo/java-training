package exercices.day6.dependency_injection.daos;

import org.springframework.data.repository.CrudRepository;

import exercices.day6.dependency_injection.models.Sale;


public interface SaleDao extends CrudRepository<Sale,Long>{

}
