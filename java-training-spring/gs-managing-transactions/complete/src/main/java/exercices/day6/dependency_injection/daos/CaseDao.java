package exercices.day6.dependency_injection.daos;

import org.springframework.data.repository.CrudRepository;

import exercices.day6.dependency_injection.models.Case;

public interface CaseDao extends CrudRepository<Case,Long>{

}
