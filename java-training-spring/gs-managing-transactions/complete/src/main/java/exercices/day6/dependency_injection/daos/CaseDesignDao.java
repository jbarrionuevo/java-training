package exercices.day6.dependency_injection.daos;

import org.springframework.data.repository.CrudRepository;

import exercices.day6.dependency_injection.models.CaseDesign;

public interface CaseDesignDao extends CrudRepository<CaseDesign,Long>{

}
