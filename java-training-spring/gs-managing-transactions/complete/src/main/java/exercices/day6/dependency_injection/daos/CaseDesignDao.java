package exercices.day6.dependency_injection.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import exercices.day6.dependency_injection.models.CaseDesign;
import exercices.day6.dependency_injection.models.CaseDevice;

public interface CaseDesignDao extends  JpaRepository<CaseDesign,Long>{

}
