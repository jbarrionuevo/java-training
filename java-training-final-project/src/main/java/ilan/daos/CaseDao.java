package ilan.daos;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import ilan.models.CaseProduct;
import ilan.models.CaseDesign;

public interface CaseDao extends JpaRepository<CaseProduct,Long>{
	Collection<CaseProduct> findByDesign(CaseDesign design);
}
