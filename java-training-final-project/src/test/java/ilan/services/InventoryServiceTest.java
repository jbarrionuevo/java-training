package ilan.services;

import static org.junit.Assert.*;
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
import ilan.daos.CaseOrderDao;
import ilan.daos.CaseProductDao;
import ilan.daos.CaseWrapperDao;
import ilan.daos.InventoryDao;
import ilan.models.CaseDesign;
import ilan.models.CaseDevice;
import ilan.models.CaseProduct;
import ilan.models.CaseWrapper;
import ilan.models.Inventory;
import ilan.models.Provider;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@ContextConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class InventoryServiceTest {

	@Mock
	private InventoryDao inventoryDaoMock;
	
	@Mock
	private CaseWrapperDao caseWrapperDaoMock;
	
	@Mock
	private CaseProductDao caseProductDaoMock;
	
	@Mock
	private CaseOrderDao caseOrderDaoMock;
	
	@InjectMocks
	InventoryService inventoryService;
	
	@Before
    public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getInventory() {
		Inventory i = new Inventory();
		when(inventoryDaoMock.findAll()).thenReturn(Arrays.asList(i));
		Inventory found = inventoryService.getInventory();
		assertEquals(i, found);
	    verify(inventoryDaoMock, times(1)).findAll();
		verifyNoMoreInteractions(inventoryDaoMock);
	}
	
	@Test
	public void getInventoryWrappers(){
		Inventory inventory = new Inventory();
		when(inventoryDaoMock.findAll()).thenReturn(Arrays.asList(inventory));
		CaseDevice dv1 = new CaseDevice("device");
		CaseDesign ds1 = new CaseDesign("design");
		CaseDevice dv2 = new CaseDevice("device 2");
		CaseDesign ds2 = new CaseDesign("design 2");
		CaseProduct p1 = new CaseProduct(ds1,dv1,100.5,new Provider("name","location"));
		CaseProduct p2 = new CaseProduct(ds2,dv2,200.5,new Provider("name 2","location 2"));
		CaseWrapper first = new CaseWrapper(p1, 100, 100, inventory);
		CaseWrapper second = new CaseWrapper(p2, 200, 200, inventory);
		when(caseWrapperDaoMock.findByInventory(inventory,new PageRequest(0,5))).thenReturn(Arrays.asList(first,second));
		Collection<CaseWrapper> wrappers = inventoryService.getInventoryWrappers(0, 5);
		assertTrue(wrappers.size()==2);
		assertTrue(wrappers.containsAll(Arrays.asList(first,second)));
		verify(caseWrapperDaoMock, times(1)).findByInventory(inventory,new PageRequest(0,5));
		verifyNoMoreInteractions(caseWrapperDaoMock);
	}
	
	@Test
	public void getAllInventoryWrappers(){
		Inventory inventory = new Inventory();
		when(inventoryDaoMock.findAll()).thenReturn(Arrays.asList(inventory));
		CaseDevice dv1 = new CaseDevice("device");
		CaseDesign ds1 = new CaseDesign("design");
		CaseDevice dv2 = new CaseDevice("device 2");
		CaseDesign ds2 = new CaseDesign("design 2");
		CaseProduct p1 = new CaseProduct(ds1,dv1,100.5,new Provider("name","location"));
		CaseProduct p2 = new CaseProduct(ds2,dv2,200.5,new Provider("name 2","location 2"));
		CaseWrapper first = new CaseWrapper(p1, 100, 100, inventory);
		CaseWrapper second = new CaseWrapper(p2, 200, 200, inventory);
		when(caseWrapperDaoMock.findByInventory(inventory)).thenReturn(Arrays.asList(first,second));
		Collection<CaseWrapper> wrappers = inventoryService.getAllInventoryWrappers();
		assertTrue(wrappers.size()==2);
		assertTrue(wrappers.containsAll(Arrays.asList(first,second)));
		verify(caseWrapperDaoMock, times(1)).findByInventory(inventory);
		verifyNoMoreInteractions(caseWrapperDaoMock);
	}
	
	@Test
	public void getInventoryCount(){
		Inventory inventory = new Inventory();
		when(inventoryDaoMock.findAll()).thenReturn(Arrays.asList(inventory));
		when(caseWrapperDaoMock.countByInventory(inventory)).thenReturn(2L);
		Long count = inventoryService.getInventoryCount();
		assertTrue(count==2L);
		verify(caseWrapperDaoMock, times(1)).countByInventory(inventory);
		verifyNoMoreInteractions(caseWrapperDaoMock);
	}
	
	@Test
	public void getCount_DesignAndDeviceNull(){
		Inventory inventory = new Inventory();
		when(inventoryDaoMock.findAll()).thenReturn(Arrays.asList(inventory));
		when(caseWrapperDaoMock.countByInventory(inventory)).thenReturn(2L);
		Long count = inventoryService.getCount(null,null);
		assertTrue(count==2L);
		verify(caseWrapperDaoMock, times(1)).countByInventory(inventory);
		verifyNoMoreInteractions(caseWrapperDaoMock);
	}
	
	@Test
	public void getCount_DeviceNull(){
		Inventory inventory = new Inventory();
		when(inventoryDaoMock.findAll()).thenReturn(Arrays.asList(inventory));
		when(caseWrapperDaoMock.countByInventoryAndMyCaseDesignName(inventory,"design")).thenReturn(2L);
		Long count = inventoryService.getCount("design",null);
		assertTrue(count==2L);
		verify(caseWrapperDaoMock, times(1)).countByInventoryAndMyCaseDesignName(inventory,"design");
		verifyNoMoreInteractions(caseWrapperDaoMock);
	}
	
	@Test
	public void getCount_DesignNull(){
		Inventory inventory = new Inventory();
		when(inventoryDaoMock.findAll()).thenReturn(Arrays.asList(inventory));
		when(caseWrapperDaoMock.countByInventoryAndMyCaseDeviceName(inventory,"device")).thenReturn(2L);
		Long count = inventoryService.getCount(null,"device");
		assertTrue(count==2L);
		verify(caseWrapperDaoMock, times(1)).countByInventoryAndMyCaseDeviceName(inventory,"device");
		verifyNoMoreInteractions(caseWrapperDaoMock);
	}
	
	@Test
	public void getCount_DesignAndDevice(){
		Inventory inventory = new Inventory();
		when(inventoryDaoMock.findAll()).thenReturn(Arrays.asList(inventory));
		when(caseWrapperDaoMock.countByInventoryAndMyCaseDesignNameAndMyCaseDeviceName(inventory,"design","device")).thenReturn(2L);
		Long count = inventoryService.getCount("design","device");
		assertTrue(count==2L);
		verify(caseWrapperDaoMock, times(1)).countByInventoryAndMyCaseDesignNameAndMyCaseDeviceName(inventory,"design","device");
		verifyNoMoreInteractions(caseWrapperDaoMock);
	}
	
	@Test
	public void getDesigns(){
		CaseDesign d1 = new CaseDesign("d1");
		CaseDesign d2 = new CaseDesign("d2");
		CaseProduct p1 = new CaseProduct(d1, new CaseDevice(), 100.5, new Provider());
		CaseProduct p2 = new CaseProduct(d2, new CaseDevice(), 100.5, new Provider());
		Inventory inventory = new Inventory();
		inventory.setStock(Arrays.asList(new CaseWrapper(p1, 10, 10, inventory), new CaseWrapper(p2, 10, 10, inventory)));
		when(inventoryDaoMock.findAll()).thenReturn(Arrays.asList(inventory));
		Collection<CaseDesign> designsFound = inventoryService.getDesigns();
		assertTrue(designsFound.size()==2);
		assertTrue(designsFound.containsAll(Arrays.asList(d1,d2)));
		verify(inventoryDaoMock, times(1)).findAll();
		verifyNoMoreInteractions(inventoryDaoMock);
	}

}
