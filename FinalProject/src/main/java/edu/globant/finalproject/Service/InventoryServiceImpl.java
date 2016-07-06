package edu.globant.finalproject.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.globant.finalproject.dao.GenericDAO;
import edu.globant.finalproject.dao.InventoryDAO;
import edu.globant.finalproject.hibernate.CaseCoverage;
import edu.globant.finalproject.hibernate.CaseStock;
import edu.globant.finalproject.model.Inventory.InventoryDTO;

@Service
public class InventoryServiceImpl extends GenericServiceImpl<InventoryDTO, Integer> implements InventoryService{
	
	private InventoryDAO inventoryDAO;
	
	public InventoryServiceImpl() {}
	
	@Autowired
    public InventoryServiceImpl(
            @Qualifier("inventoryDAOImpl") GenericDAO<InventoryDTO, Integer> genericDao) {
        super(genericDao);
        this.inventoryDAO = (InventoryDAO) genericDao;
    }

}
