package exercices.day6.dependency_injection.services;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exercices.day6.dependency_injection.daos.InventoryDao;
import exercices.day6.dependency_injection.daos.SaleDao;

@Service
public class SaleService {
	
	@Autowired
	private SaleDao saleDao;
	
	@Autowired
	private InventoryDao inventoryDao;

	
	public SaleDao getSaleDao() {
		return saleDao;
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
