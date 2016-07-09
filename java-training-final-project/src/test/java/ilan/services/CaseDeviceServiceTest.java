package ilan.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import ilan.Application;
import ilan.daos.CaseDesignDao;
import ilan.daos.CaseDeviceDao;
import ilan.models.CaseDesign;
import ilan.models.CaseDevice;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@ContextConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class CaseDeviceServiceTest {

	@Mock
	CaseDeviceDao caseDeviceDaoMock;
	
	@InjectMocks
	CaseDeviceService cartDeviceService;
	
	@Before
    public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void saveCaseDevice() throws Exception {
		CaseDevice newDevice = new CaseDevice("device");
		when(caseDeviceDaoMock.save(newDevice)).thenReturn(newDevice);
		CaseDevice deviceReturned = cartDeviceService.saveCaseDevice(newDevice);
		assertEquals(deviceReturned, newDevice);
	    verify(caseDeviceDaoMock, times(1)).save(newDevice);
		verifyNoMoreInteractions(caseDeviceDaoMock);
	}

}
