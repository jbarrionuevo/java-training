package exercices.day6.dependency_injection.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import exercices.day6.dependency_injection.models.Case;
import exercices.day6.dependency_injection.models.CaseDesign;

public interface CaseDao extends JpaRepository<Case,Long>{

}
