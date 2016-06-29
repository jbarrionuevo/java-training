package ilan.daos;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import ilan.models.CaseDesign;
import ilan.models.CaseDevice;
import ilan.models.CaseProduct;
import ilan.models.CaseWrapper;
import ilan.models.Inventory;

public interface CaseWrapperDao extends JpaRepository<CaseWrapper,Long>{
	CaseWrapper findByMyCase(CaseProduct myCase);
	List<CaseWrapper> findByInventory(Inventory inventory, Pageable pageable);
	List<CaseWrapper> findByInventoryAndMyCaseDesignName(Inventory inventory, String caseDesignName, Pageable pageable);
	List<CaseWrapper> findByInventoryAndMyCaseDeviceName(Inventory inventory, String caseDeviceName, Pageable pageable);
	long countByInventory(Inventory inventory);
	long countByInventoryAndMyCaseDesignName(Inventory inventory, String caseDesignName);
	long countByInventoryAndMyCaseDeviceName(Inventory inventory, String caseDeviceName);
	long countByInventoryAndMyCaseDesignNameAndMyCaseDeviceName(Inventory inventory, String caseDesignName, String caseDeviceName);
}
