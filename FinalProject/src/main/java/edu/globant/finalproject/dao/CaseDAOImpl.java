package edu.globant.finalproject.dao;


import org.springframework.stereotype.Repository;

import edu.globant.finalproject.hibernate.CaseCoverage;
import edu.globant.finalproject.model.Case.CaseDTO;




@Repository
public class CaseDAOImpl extends GenericDAOImpl<CaseCoverage,Integer> implements CaseDAO{

}
