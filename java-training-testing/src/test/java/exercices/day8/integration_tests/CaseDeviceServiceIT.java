package exercices.day8.integration_tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.globant.testing.integration.Person;
import edu.globant.testing.integration.PersonDAO;
import edu.globant.testing.integration.PersonService;
import exercices.Application;
import exercices.day6.dependency_injection.models.CaseDevice;
import exercices.day6.dependency_injection.services.CaseDeviceService;

@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = Application.class)
//@WebAppConfiguration
//@IntegrationTest({"server.port=9090"})
public class CaseDeviceServiceIT {

	private CaseDeviceService caseDeviceService;
	
	@Before
    public void setUp() {
		caseDeviceService = new CaseDeviceService();
    }
	
	@Test
    public void storeAndRetrieve() {
		caseDeviceService.saveCaseDevice(new CaseDevice("test"));
		CaseDevice retrieved = caseDeviceService.findByName("test");

        assertThat("The case device just created and retrieved is null", retrieved, notNullValue());
        assertThat("Wrong case device just created and retrieved", retrieved.getName(), equalTo("test"));
    }
}
