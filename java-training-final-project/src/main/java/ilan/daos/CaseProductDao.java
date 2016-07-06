package ilan.daos;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import ilan.models.CaseProduct;
import ilan.models.CaseDesign;
import ilan.models.CaseDevice;

public interface CaseProductDao extends JpaRepository<CaseProduct,Long>{
	Collection<CaseProduct> findByDesign(CaseDesign design);
	CaseProduct findByDesignAndDevice(CaseDesign design,CaseDevice device);
	CaseProduct findByDesignNameAndDeviceName(String design,String device);
}
