package edu.globant.day6.exercises.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.globant.day6.exercises.DAO.CaseSellerDAO;

@Service
public class CaseSellerService {
	
	@Autowired
	CaseSellerDAO caseSellerDAO;
	

}
