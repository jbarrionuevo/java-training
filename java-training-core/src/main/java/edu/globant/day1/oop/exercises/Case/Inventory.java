package edu.globant.day1.oop.exercises.Case;

import java.util.HashMap;

public class Inventory {
	private HashMap<Case,Integer> cases;

	public HashMap<Case, Integer> getCases() {
		return cases;
	}

	public void setCases(HashMap<Case, Integer> cases) {
		this.cases = cases;
	}
	
}
