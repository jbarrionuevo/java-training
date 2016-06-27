package ilan.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import ilan.models.CaseDesign;
import ilan.models.CaseDevice;

public interface CaseDesignDao extends  JpaRepository<CaseDesign,Long>{
	public CaseDesign findByName(String name);
}
