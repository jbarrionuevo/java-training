package edu.globant.day6.exercises.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.globant.day6.exercises.DAO.InventoryServiceDAO;

@Service
public class InventoryService {
	
	@Autowired
	InventoryServiceDAO inventoryServiceDao;

	public InventoryServiceDAO getInventoryServiceDao() {
		return inventoryServiceDao;
	}

	public void setInventoryServiceDao(InventoryServiceDAO inventoryServiceDao) {
		this.inventoryServiceDao = inventoryServiceDao;
	}
}
