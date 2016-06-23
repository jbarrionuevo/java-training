package edu.globant.finalProject.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import edu.globant.finalProject.dao.CaseDAO;
import edu.globant.finalProject.model.Case.Case;

public class CaseServiceImpl implements CaseService{
	
	@Autowired
	CaseDAO caseDAO;

	@Override
	public void create(Case c) {
		caseDAO.save(c);
	}

	@Override
	public ArrayList<Case> getAll() {
		ArrayList<Case> cases = caseDAO.getAll();
		return cases; 
	}

	@Override
	public Case get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Case c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int checkStock(Case c) {
		// TODO Auto-generated method stub
		return 0;
	}

}
