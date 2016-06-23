package exercices.day6.dependency_injection.services;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import exercices.day6.dependency_injection.daos.InventoryDao;
import exercices.day6.dependency_injection.daos.SaleDao;
import exercices.day6.dependency_injection.models.Sale;

@Service
public class SaleService {
	private final static Logger log = LoggerFactory.getLogger(SaleService.class);

	@Autowired
	private SaleDao saleDao;
	
	@Autowired
	private InventoryDao inventoryDao;

	
	public SaleDao getSaleDao() {
		return saleDao;
	}
	
	@Transactional
	public void registerSales(Sale... sales){
		 for (Sale sale: sales) {
	            log.info("Persisting Order [" + sale + "] to database...");
	            saleDao.save(sale);
	     }
	}

	public void setSaleDao(SaleDao saleDao) {
		this.saleDao = saleDao;
	}

	public InventoryDao getInventoryDao() {
		return inventoryDao;
	}

	public void setInventoryDao(InventoryDao inventoryDao) {
		this.inventoryDao = inventoryDao;
	}
	
}
