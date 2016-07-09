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
import ilan.daos.ProviderDao;
import ilan.models.CaseDesign;
import ilan.models.Provider;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@ContextConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class ProviderServiceTest {

	@Mock
	ProviderDao providerDaoMock;
	
	@InjectMocks
	ProviderService providerService;
	
	@Before
    public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void saveProvider() throws Exception {
		Provider newProvider = new Provider("name","location");
		when(providerDaoMock.save(newProvider)).thenReturn(newProvider);
		Provider providerReturned = providerService.saveProvider(newProvider);
		assertEquals(providerReturned, newProvider);
	    verify(providerDaoMock, times(1)).save(newProvider);
		verifyNoMoreInteractions(providerDaoMock);
	}
	
	@Test
	public void saveProviders() throws Exception {
		Provider newProvider = new Provider("name","location");
		Provider newProvider2 = new Provider("name2","location2");
		Provider newProvider3 = new Provider("name3","location3");
		providerService.saveProviders(newProvider,newProvider2,newProvider3);
	    verify(providerDaoMock, times(3)).save(any(Provider.class));
		verifyNoMoreInteractions(providerDaoMock);
	}

}
