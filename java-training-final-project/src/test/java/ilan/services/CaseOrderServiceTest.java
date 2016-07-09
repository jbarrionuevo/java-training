package ilan.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import org.junit.Before;
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
import ilan.daos.CaseOrderDao;
import ilan.models.CaseOrder;
import ilan.models.Customer;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@ContextConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class CaseOrderServiceTest {

	@Mock
	CaseOrderDao caseOrderDaoMock;
	
	@InjectMocks
	CaseOrderService cartOrderService;
	
	@Before
    public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void saveCaseOrder() throws Exception {
		CaseOrder newOrder = new CaseOrder(new HashMap<Long,Integer>(),new Date(), new Customer());
		when(caseOrderDaoMock.save(newOrder)).thenReturn(newOrder);
		CaseOrder orderReturned = cartOrderService.save(newOrder);
		assertEquals(orderReturned, newOrder);
	    verify(caseOrderDaoMock, times(1)).save(newOrder);
		verifyNoMoreInteractions(caseOrderDaoMock);
	}
	
	@Test
	public void saveCaseOrders() throws Exception {
		CaseOrder newOrder = new CaseOrder(new HashMap<Long,Integer>(),new Date(), new Customer());
		CaseOrder newOrder2 = new CaseOrder(new HashMap<Long,Integer>(),new Date(), new Customer());
		CaseOrder newOrder3 = new CaseOrder(new HashMap<Long,Integer>(),new Date(), new Customer());
		cartOrderService.saveOrders(newOrder,newOrder2,newOrder3);
	    verify(caseOrderDaoMock, times(3)).save(any(CaseOrder.class));
		verifyNoMoreInteractions(caseOrderDaoMock);
	}
	
	@Test
	public void findAll() {
		CaseOrder order = new CaseOrder(new HashMap<Long,Integer>(),new Date(), new Customer());
		CaseOrder order2 = new CaseOrder(new HashMap<Long,Integer>(),new Date(), new Customer());
		CaseOrder order3 = new CaseOrder(new HashMap<Long,Integer>(),new Date(), new Customer());
		when(caseOrderDaoMock.findAll()).thenReturn(Arrays.asList(order,order2,order3));
		Collection<CaseOrder> found = cartOrderService.findAllOrders();
		assertTrue(found.size()==3);
		assertTrue(found.containsAll(Arrays.asList(order,order2,order3)));
	    verify(caseOrderDaoMock, times(1)).findAll();
		verifyNoMoreInteractions(caseOrderDaoMock);
	}

}
