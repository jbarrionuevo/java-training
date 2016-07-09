package ilan.services;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.PageRequest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import ilan.Application;
import ilan.daos.OrderAlertDao;
import ilan.models.CaseDesign;
import ilan.models.CaseDevice;
import ilan.models.CaseProduct;
import ilan.models.CaseWrapper;
import ilan.models.Inventory;
import ilan.models.OrderAlert;
import ilan.models.Provider;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@ContextConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class OrderAlertServiceTest {

	@Mock
	private OrderAlertDao orderalertDaoMock;
	
	@InjectMocks
	OrderAlertService orderAlertService;
	
	@Before
    public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void findAll(){
		CaseDevice dv1 = new CaseDevice("device");
		CaseDesign ds1 = new CaseDesign("design");
		CaseDevice dv2 = new CaseDevice("device 2");
		CaseDesign ds2 = new CaseDesign("design 2");
		CaseProduct p1 = new CaseProduct(ds1,dv1,100.5,new Provider("name","location"));
		CaseProduct p2 = new CaseProduct(ds2,dv2,200.5,new Provider("name 2","location 2"));
		OrderAlert o1 = new OrderAlert(100, p1);
		OrderAlert o2 = new OrderAlert(100, p2);
		when(orderalertDaoMock.findAll()).thenReturn(Arrays.asList(o1,o2));
		Collection<OrderAlert> orders= orderAlertService.findAll();
		assertTrue(orders.size()==2);
		assertTrue(orders.containsAll(Arrays.asList(o1,o2)));
		verify(orderalertDaoMock, times(1)).findAll();
		verifyNoMoreInteractions(orderalertDaoMock);
	}
	
	@Test
	public void findNotMadeAlerts(){
		CaseDevice dv1 = new CaseDevice("device");
		CaseDesign ds1 = new CaseDesign("design");
		CaseDevice dv2 = new CaseDevice("device 2");
		CaseDesign ds2 = new CaseDesign("design 2");
		CaseProduct p1 = new CaseProduct(ds1,dv1,100.5,new Provider("name","location"));
		CaseProduct p2 = new CaseProduct(ds2,dv2,200.5,new Provider("name 2","location 2"));
		OrderAlert o1 = new OrderAlert(100, p1);
		OrderAlert o2 = new OrderAlert(100, p2);
		when(orderalertDaoMock.findByMade(false)).thenReturn(Arrays.asList(o1,o2));
		Collection<OrderAlert> orders= orderAlertService.findNotMadeAlerts();
		assertTrue(orders.size()==2);
		assertTrue(orders.containsAll(Arrays.asList(o1,o2)));
		verify(orderalertDaoMock, times(1)).findByMade(false);
		verifyNoMoreInteractions(orderalertDaoMock);
	}

}
