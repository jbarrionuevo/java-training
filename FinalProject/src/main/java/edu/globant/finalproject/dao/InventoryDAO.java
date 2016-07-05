package edu.globant.finalproject.dao;

import java.util.ArrayList;
import java.util.List;

import edu.globant.finalproject.hibernate.Case;
import edu.globant.finalproject.hibernate.CaseStock;

public interface InventoryDAO {
	public void add(Case c);
	public List<CaseStock> getAll();
}
