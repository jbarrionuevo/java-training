package ilan.daos;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import ilan.models.CaseDesign;
import ilan.models.CaseProduct;
import ilan.models.CaseWrapper;

public interface CaseWrapperDao extends JpaRepository<CaseWrapper,Long>{
	CaseWrapper findByMyCase(CaseProduct myCase);
}
