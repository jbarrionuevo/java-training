package ilan.services;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
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
import ilan.exceptions.CaseDesignNotFoundException;
import ilan.exceptions.CaseDeviceNotFoundException;
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
	
	@Test
	public void saveCaseDevices() throws Exception {
		CaseDevice newDevice = new CaseDevice("Device");
		CaseDevice newDevice2 = new CaseDevice("Device 2");
		CaseDevice newDevice3 = new CaseDevice("Device 3");
		cartDeviceService.saveCaseDevices(newDevice,newDevice2,newDevice3);
	    verify(caseDeviceDaoMock, times(3)).save(any(CaseDevice.class));
		verifyNoMoreInteractions(caseDeviceDaoMock);
	}
	
	@Test(expected = CaseDeviceNotFoundException.class) 
	public void findByName_CaseDesignNotFound() {
		when(caseDeviceDaoMock.findByName("name")).thenReturn(null);
		cartDeviceService.findByName("name");
	}
	
	@Test
	public void findByName_CaseDesignFound() {
		CaseDevice device = new CaseDevice("Device");
		when(caseDeviceDaoMock.findByName("name")).thenReturn(device);
		CaseDevice found = cartDeviceService.findByName("name");
		assertEquals(device, found);
	    verify(caseDeviceDaoMock, times(1)).findByName("name");
		verifyNoMoreInteractions(caseDeviceDaoMock);
	}
	
	@Test(expected = CaseDeviceNotFoundException.class) 
	public void findBy_CaseDesignNotFound() {
		when(caseDeviceDaoMock.findOne(1L)).thenReturn(null);
		cartDeviceService.findBy(1L);
	}
	
	@Test
	public void findBy_CaseDesignFound() {
		CaseDevice device = new CaseDevice("Device");
		when(caseDeviceDaoMock.findOne(1L)).thenReturn(device);
		CaseDevice found = cartDeviceService.findBy(1L);
		assertEquals(device, found);
	    verify(caseDeviceDaoMock, times(1)).findOne(1L);
		verifyNoMoreInteractions(caseDeviceDaoMock);
	}

}
