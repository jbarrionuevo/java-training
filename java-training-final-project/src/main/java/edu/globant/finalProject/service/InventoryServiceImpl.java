package edu.globant.finalProject.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.globant.finalProject.dao.InventoryDAO;
import edu.globant.finalProject.model.Case.Case;
import edu.globant.finalProject.model.Inventory.CaseStock;

@Service
public class InventoryServiceImpl implements InventoryService{
	
	@Autowired
	InventoryDAO inventoryDAO;

	@Transactional
	@Override
	public void add(Case c) {
		inventoryDAO.add(c);
	}

	@Override
	public ArrayList<CaseStock> getAll() {
		return inventoryDAO.getAll();
	}
	
}
