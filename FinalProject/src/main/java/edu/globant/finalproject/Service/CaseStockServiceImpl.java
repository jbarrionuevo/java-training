package edu.globant.finalproject.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.globant.finalproject.dao.CaseStockDAO;
import edu.globant.finalproject.dao.GenericDAO;
import edu.globant.finalproject.dao.InventoryDAO;
import edu.globant.finalproject.hibernate.CaseStock;
import edu.globant.finalproject.model.Inventory.CaseStockDTO;
import edu.globant.finalproject.model.Inventory.InventoryDTO;

@Service
public class CaseStockServiceImpl extends GenericServiceImpl<CaseStock, Integer> implements CaseStockService{

	private CaseStockDAO caseStockDAO;
	
	public CaseStockServiceImpl() {}
	
	@Autowired
    public CaseStockServiceImpl(
            @Qualifier("caseStockDAOImpl") GenericDAO<CaseStock, Integer> genericDao) {
        super(genericDao);
        this.caseStockDAO = (CaseStockDAO) genericDao;
    }
}
