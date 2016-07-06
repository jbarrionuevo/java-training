package edu.globant.finalproject.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import edu.globant.finalproject.dao.CaseDAOImpl;
import edu.globant.finalproject.model.Case.CaseDTO;


@Service
public class CaseServiceImpl implements CaseService{
	
	@Autowired
	CaseDAOImpl caseDAO;
	
	//@Autowired
	//Inventory inventory;

	@Transactional
	@Override
	public void create(CaseDTO c) {
		caseDAO.save(c);
	}

	@Override
	public ArrayList<CaseDTO> getAll() {
		ArrayList<CaseDTO> cases = caseDAO.getAll();
		return cases; 
	}

	@Override
	public CaseDTO get(int id) {
		return null;
	}

	@Transactional
	@Override
	public void update(CaseDTO c) {
		
	}

	@Override
	public int checkStock(CaseDTO c) {
		return 0;
	}

}
