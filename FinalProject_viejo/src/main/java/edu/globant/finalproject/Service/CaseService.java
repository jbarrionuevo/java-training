package edu.globant.finalproject.Service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import edu.globant.finalproject.model.Case.CaseDTO;



public interface CaseService {
	public void create(CaseDTO c);
	public ArrayList<CaseDTO> getAll();
	public CaseDTO get(int id);
	public void update(CaseDTO c);
	public int checkStock(CaseDTO c);
}
