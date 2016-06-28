package edu.globant.day7.exercises.integration;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.notNullValue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.globant.day6.exercises.model.Case;
import edu.globant.day6.exercises.model.Design;
import edu.globant.day6.exercises.model.Device;
import edu.globant.day6.exercises.services.CaseService;

public class CaseServiceIT {
	
		@Autowired
		private CaseService caseService;
		
		@Test
	    public void storeAndRetrieve() {
			Case c = new Case(new Design("test"),new Device("test"),10.1, 45);
			caseService.save(c);
			
			Case retrieved = caseService.find(c);

	        assertThat("Retrieved case ", retrieved, notNullValue());
	        assertThat("Wrong case design ", retrieved.getDesign().getName(), equalTo("test"));
	        assertThat("Wrong case device ", retrieved.getDevice().getName(), equalTo("test"));
		}
	}