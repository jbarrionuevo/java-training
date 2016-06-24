package edu.globant.finalProject.model.Inventory;

import java.util.HashMap;
import java.util.Observable;

import edu.globant.finalProject.model.Case.Case;

public class Inventory{
	private HashMap<Case,Integer> cases;

	public HashMap<Case, Integer> getCases() {
		return cases;
	}

	public void setCases(HashMap<Case, Integer> cases) {
		this.cases = cases;
	}
	
}
