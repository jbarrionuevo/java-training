package edu.globant.finalProject.service;

import java.util.ArrayList;

import edu.globant.finalProject.model.Case.Case;


public interface CaseService {
	public void create(Case c);
	public ArrayList<Case> getAll();
	public Case get(int id);
	public void update(Case c);
	public int checkStock(Case c);
	public boolean hasLowStock(Case c);
}
