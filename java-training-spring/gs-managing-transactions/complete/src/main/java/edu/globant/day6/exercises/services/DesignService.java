package edu.globant.day6.exercises.services;
import javax.xml.ws.WebServiceClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.globant.day6.exercises.DAO.DesignDAO;
import edu.globant.day6.exercises.model.Design;

@Service
public class DesignService {

	@Autowired
	DesignDAO designDAO;
	
	public void saveDesign(Design aDesign) {
		designDAO.save(aDesign);
	}

}
