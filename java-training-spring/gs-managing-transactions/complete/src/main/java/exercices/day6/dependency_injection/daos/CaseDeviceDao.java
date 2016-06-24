package exercices.day6.dependency_injection.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import exercices.day6.dependency_injection.models.CaseDevice;
import exercices.day6.dependency_injection.models.CaseSeller;

public interface CaseDeviceDao extends JpaRepository<CaseDevice,Long>{
	public CaseDevice findByName(String name);
}
