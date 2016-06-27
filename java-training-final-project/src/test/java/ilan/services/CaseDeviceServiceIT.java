package ilan.services;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import ilan.Application;
import ilan.models.CaseDevice;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({"server.port=9090"})
public class CaseDeviceServiceIT {

	@Autowired
	private CaseDeviceService caseDeviceService;
	
	@Test
    public void storeAndRetrieve() {
		caseDeviceService.saveCaseDevice(new CaseDevice("test"));
		CaseDevice retrieved = caseDeviceService.findByName("test");

        assertThat("The case device just created and retrieved is null", retrieved, notNullValue());
        assertThat("Wrong case device just created and retrieved", retrieved.getName(), equalTo("test"));
    }
}
