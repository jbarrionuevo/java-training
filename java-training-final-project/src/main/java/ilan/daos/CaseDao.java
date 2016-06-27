package ilan.daos;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import ilan.models.Case;
import ilan.models.CaseDesign;

public interface CaseDao extends JpaRepository<Case,Long>{
	Collection<Case> findByDesign(CaseDesign design);
}
