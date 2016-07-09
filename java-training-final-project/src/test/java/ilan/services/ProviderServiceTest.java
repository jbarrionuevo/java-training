package ilan.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import ilan.Application;
import ilan.daos.CaseOrderDao;
import ilan.daos.OrderAlertDao;
import ilan.daos.ProviderDao;
import ilan.exceptions.OrderAlertNotFoundException;
import ilan.exceptions.OrderAlreadyMadeException;
import ilan.exceptions.ProviderNotFoundException;
import ilan.models.CaseOrder;
import ilan.models.CaseProduct;
import ilan.models.OrderAlert;
import ilan.models.Provider;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@ContextConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class ProviderServiceTest {

	@Mock
	ProviderDao providerDaoMock;
	
	@Mock
	OrderAlertDao orderAlertDaoMock;
	
	@Mock
	CaseOrderDao caseOrderDaoMock;
	
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
	
	@Test
	public void findAllProviders() {
		Provider newProvider = new Provider("name","location");
		Provider newProvider2 = new Provider("name2","location2");
		Provider newProvider3 = new Provider("name3","location3");
		when(providerDaoMock.findAll()).thenReturn(Arrays.asList(newProvider,newProvider2,newProvider3));
		Collection<Provider> found = providerService.findAllProviders();
		assertTrue(found.size()==3);
		assertTrue(found.containsAll(Arrays.asList(newProvider,newProvider2,newProvider3)));
	    verify(providerDaoMock, times(1)).findAll();
		verifyNoMoreInteractions(providerDaoMock);
	}
	
	@Test
	public void findAllProvidersPaginated() {
		Provider newProvider = new Provider("name","location");
		Provider newProvider2 = new Provider("name2","location2");
		Provider newProvider3 = new Provider("name3","location3");
		Page<Provider> page = new PageImpl<>(Arrays.asList(newProvider,newProvider2,newProvider3));
		when(providerDaoMock.findAll(new PageRequest(0,5))).thenReturn(page);
		Collection<Provider> found = providerService.findAllProviders(0,5);
		assertTrue(found.size()==3);
		assertTrue(found.containsAll(Arrays.asList(newProvider,newProvider2,newProvider3)));
	    verify(providerDaoMock, times(1)).findAll(new PageRequest(0,5));
		verifyNoMoreInteractions(providerDaoMock);
	}
	
	@Test(expected = ProviderNotFoundException.class) 
	public void addOrder_ProviderNotfound(){
		when(providerDaoMock.findOne(1L)).thenReturn(null);
		providerService.addOrder(1L, new CaseOrder(), 2L);
	}
	
	@Test 
	public void addOrder_Providerfound_OrderAlertIdIsZero(){
		Provider p = new Provider("name", "location");
		when(providerDaoMock.findOne(1L)).thenReturn(p);
		providerService.addOrder(1L, new CaseOrder(), 0L);
	}
	
	@Test(expected = OrderAlertNotFoundException.class) 
	public void addOrder_Providerfound_OrderAlertNotFound(){
		Provider p = new Provider("name", "location");
		when(providerDaoMock.findOne(1L)).thenReturn(p);
		when(orderAlertDaoMock.findOne(1L)).thenReturn(null);
		providerService.addOrder(1L, new CaseOrder(), 1L);
	}
	
	@Test(expected = OrderAlreadyMadeException.class) 
	public void addOrder_Providerfound_OrderAlertFoundButMade(){
		Provider p = new Provider("name", "location");
		OrderAlert o = new OrderAlert(10, new CaseProduct());
		o.setMade(true);
		when(providerDaoMock.findOne(1L)).thenReturn(p);
		when(orderAlertDaoMock.findOne(1L)).thenReturn(o);
		providerService.addOrder(1L, new CaseOrder(), 1L);
	}
	
	@Test
	public void addOrder_Providerfound_OrderAlertFoundAndNotMade(){
		Provider p = new Provider("name", "location");
		OrderAlert o = new OrderAlert(10, new CaseProduct());
		when(providerDaoMock.findOne(1L)).thenReturn(p);
		when(orderAlertDaoMock.findOne(1L)).thenReturn(o);
		providerService.addOrder(1L, new CaseOrder(), 1L);
		assertTrue(o.isMade());
		verify(orderAlertDaoMock, times(1)).save(any(OrderAlert.class));
		verify(providerDaoMock, times(1)).save(any(Provider.class));
		verify(orderAlertDaoMock, times(1)).findOne(1L);
		verify(providerDaoMock, times(1)).findOne(1L);
		verifyNoMoreInteractions(providerDaoMock);
		verifyNoMoreInteractions(orderAlertDaoMock);
	}
	
	@Test(expected = ProviderNotFoundException.class) 
	public void getProviderOrders_ProviderNotfound(){
		when(providerDaoMock.findOne(1L)).thenReturn(null);
		providerService.getProviderOrders(1L, "false");
	}

	@Test
	public void getProviderOrders_Providerfound_AllDelivered(){
		Provider p = new Provider("name", "location");
		CaseOrder o = new CaseOrder();
		Collection<CaseOrder> orders = new ArrayList<CaseOrder>(Arrays.asList(o));
		when(providerDaoMock.findOne(1L)).thenReturn(p);
		when(caseOrderDaoMock.findByThirdPartyParticipant(p)).thenReturn(orders);
		Collection<CaseOrder> ordersFound = providerService.getProviderOrders(1L, "all");
		assertTrue(ordersFound.size()==1);
		assertTrue(ordersFound.contains(o));
		verify(providerDaoMock, times(1)).findOne(1L);
		verifyNoMoreInteractions(providerDaoMock);
		verify(caseOrderDaoMock, times(1)).findByThirdPartyParticipant(p);
		verifyNoMoreInteractions(caseOrderDaoMock);
	}
	
	@Test
	public void getProviderOrders_Providerfound_NotDelivered(){
		Provider p = new Provider("name", "location");
		CaseOrder o = new CaseOrder();
		Collection<CaseOrder> orders = new ArrayList<CaseOrder>(Arrays.asList(o));
		when(providerDaoMock.findOne(1L)).thenReturn(p);
		when(caseOrderDaoMock.findByThirdPartyParticipantAndDateOfDeliveryIsNull(p)).thenReturn(orders);
		Collection<CaseOrder> ordersFound = providerService.getProviderOrders(1L, "false");
		assertTrue(ordersFound.size()==1);
		assertTrue(ordersFound.contains(o));
		verify(providerDaoMock, times(1)).findOne(1L);
		verifyNoMoreInteractions(providerDaoMock);
		verify(caseOrderDaoMock, times(1)).findByThirdPartyParticipantAndDateOfDeliveryIsNull(p);
		verifyNoMoreInteractions(caseOrderDaoMock);
	}
	
	@Test
	public void getProviderOrders_Providerfound_Delivered(){
		Provider p = new Provider("name", "location");
		CaseOrder o = new CaseOrder();
		Collection<CaseOrder> orders = new ArrayList<CaseOrder>(Arrays.asList(o));
		when(providerDaoMock.findOne(1L)).thenReturn(p);
		when(caseOrderDaoMock.findByThirdPartyParticipantAndDateOfDeliveryIsNotNull(p)).thenReturn(orders);
		Collection<CaseOrder> ordersFound = providerService.getProviderOrders(1L, "true");
		assertTrue(ordersFound.size()==1);
		assertTrue(ordersFound.contains(o));
		verify(providerDaoMock, times(1)).findOne(1L);
		verifyNoMoreInteractions(providerDaoMock);
		verify(caseOrderDaoMock, times(1)).findByThirdPartyParticipantAndDateOfDeliveryIsNotNull(p);
		verifyNoMoreInteractions(caseOrderDaoMock);
	}

}
