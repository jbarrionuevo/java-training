package edu.globant.finalProject.service;

import org.springframework.beans.factory.annotation.Autowired;

import edu.globant.finalProject.dao.InventoryDAO;
import edu.globant.finalProject.model.Case.Case;

public class InventoryServiceImpl implements InventoryService{
	
	@Autowired
	InventoryDAO inventoryDAO;

	@Override
	public void add(Case c) {
		inventoryDAO.add(c);
	}
	
}
