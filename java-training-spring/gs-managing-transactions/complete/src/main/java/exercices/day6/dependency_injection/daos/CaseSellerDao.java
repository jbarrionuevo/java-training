package exercices.day6.dependency_injection.daos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import exercices.day6.Application;
import exercices.day6.dependency_injection.models.Case;
import exercices.day6.dependency_injection.models.CaseSeller;
import exercices.day6.dependency_injection.models.Inventory;

public interface CaseSellerDao extends JpaRepository<CaseSeller,Long>{


}
