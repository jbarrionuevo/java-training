package edu.globant.finalProject.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.globant.finalProject.dao.CaseDAO;
import edu.globant.finalProject.model.Case.Case;
import edu.globant.finalProject.model.Inventory.Inventory;

@Service
public class CaseServiceImpl implements CaseService{
	
	@Autowired
	CaseDAO caseDAO;
	
	@Autowired
	Inventory inventory;

	@Transactional
	public void create(Case c) {
		caseDAO.save(c);
	}

	public ArrayList<Case> getAll() {
		ArrayList<Case> cases = caseDAO.getAll();
		return cases; 
	}

	public Case get(int id) {
		return null;
	}

	@Transactional
	public void update(Case c) {
		
	}

	public int checkStock(Case c) {
		return 0;
	}

}
