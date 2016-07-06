package edu.globant.finalproject.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.globant.finalproject.dao.InventoryDAO;
import edu.globant.finalproject.hibernate.Case;
import edu.globant.finalproject.hibernate.CaseStock;

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
	public List<CaseStock> getAll() {
		return inventoryDAO.getAll();
	}
	
}
