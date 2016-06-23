package edu.globant.finalProject.dao;

import java.util.ArrayList;

import edu.globant.finalProject.model.Case.Case;

public class CaseDAO {

	public void save(Case c) {
		System.out.println("guardo en la bd el case: "+c.getPrice());
	}

	public ArrayList<Case> getAll() {
		ArrayList<Case> cases = new ArrayList<Case>();
		System.out.println("busco todos los cases en la bd y los devuelvo");
		return cases;
	}

}
