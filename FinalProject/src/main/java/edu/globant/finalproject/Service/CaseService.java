package edu.globant.finalproject.Service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import edu.globant.finalproject.hibernate.CaseCoverage;
import edu.globant.finalproject.model.Case.CaseDTO;


public interface CaseService extends GenericService<CaseCoverage, Integer>{
	public int checkStock(CaseCoverage c);
}
