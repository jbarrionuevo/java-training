package edu.globant.finalproject.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.globant.finalproject.dao.CaseDAO;
import edu.globant.finalproject.dao.CaseDAOImpl;
import edu.globant.finalproject.dao.GenericDAO;
import edu.globant.finalproject.dao.InventoryDAO;
import edu.globant.finalproject.hibernate.CaseCoverage;
import edu.globant.finalproject.model.Case.CaseDTO;
import edu.globant.finalproject.model.Inventory.InventoryDTO;


@Service
public class CaseServiceImpl extends GenericServiceImpl<CaseCoverage, Integer> implements CaseService{
	
	private CaseDAO caseDAO;
	public CaseServiceImpl() {}
	
	@Autowired
    public CaseServiceImpl(
            @Qualifier("caseDAOImpl") GenericDAO<CaseCoverage, Integer> genericDao) {
        super(genericDao);
        this.caseDAO = (CaseDAO) genericDao;
    }

	@Override
	public int checkStock(CaseCoverage c) {
		// TODO: implementar
		return 0;
	}
}
