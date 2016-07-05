package edu.globant.finalproject.dao;

import java.util.ArrayList;

import edu.globant.finalproject.model.Case.CaseDTO;


public interface CaseDAO {
	void save(CaseDTO c);
	ArrayList<CaseDTO> getAll();
}
