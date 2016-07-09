package ilan.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Arrays;

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
import ilan.daos.CaseProductDao;
import ilan.daos.CaseSellerDao;
import ilan.daos.CaseWrapperDao;
import ilan.daos.InventoryDao;
import ilan.daos.SaleDao;
import ilan.enums.SaleStatus;
import ilan.exceptions.CaseSellerNotFoundException;
import ilan.models.CaseSeller;
import ilan.models.Inventory;
import ilan.models.Sale;
import ilan.models.StoreSeller;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@ContextConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class SaleServiceTest {

	@Mock
	private SaleDao saleDaoMock;
	@Mock
	private CaseSellerDao caseSellerDaoMock;
	@Mock
	private CaseWrapperDao caseWrapperDaoMock;
	@Mock
	private CaseProductDao caseProductDaoMock;
	@Mock
	private InventoryDao inventoryDaoMock;
	@Mock
	private CaseOrderDao caseOrderDaoMock;
	
	@InjectMocks
	SaleService saleService;
	
	@Before
    public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void saveSale() throws Exception {
		Sale newSale = new Sale();
		when(saleDaoMock.save(newSale)).thenReturn(newSale);
		Sale saleReturned = saleService.save(newSale);
		assertEquals(saleReturned, newSale);
	    verify(saleDaoMock, times(1)).save(newSale);
		verifyNoMoreInteractions(saleDaoMock);
	}
	
	@Test
	public void saveSales() throws Exception {
		Sale newSale = new Sale();
		Sale newSale2 = new Sale();
		Sale newSale3 = new Sale();
		saleService.registerSales(newSale,newSale2,newSale3);
	    verify(saleDaoMock, times(3)).save(any(Sale.class));
		verifyNoMoreInteractions(saleDaoMock);
	}
	
	@Test(expected = CaseSellerNotFoundException.class) 
	public void getCount_SellerNotFound(){
		when(caseSellerDaoMock.findOne(1L)).thenReturn(null);
		saleService.getCount(1L, SaleStatus.DRAFT.toString());
	}
	
	@Test
	public void getCount_SellerFound_AllStatus(){
		CaseSeller cs = new StoreSeller();
		when(caseSellerDaoMock.findOne(1L)).thenReturn(cs);
		when(saleDaoMock.countBySeller(cs)).thenReturn(2L);
		Long result = saleService.getCount(1L, "all");
		assertTrue(result==2L);
		verify(caseSellerDaoMock, times(2)).findOne(1L);
		verifyNoMoreInteractions(caseSellerDaoMock);
		verify(saleDaoMock, times(1)).countBySeller(cs);
		verifyNoMoreInteractions(saleDaoMock);
	}
	
	@Test
	public void getCount_SellerFound_SomeStatus(){
		CaseSeller cs = new StoreSeller();
		when(caseSellerDaoMock.findOne(1L)).thenReturn(cs);
		when(saleDaoMock.countBySellerAndStatus(cs,SaleStatus.DRAFT)).thenReturn(2L);
		Long result = saleService.getCount(1L, "DRAFT");
		assertTrue(result==2L);
		verify(caseSellerDaoMock, times(1)).findOne(1L);
		verifyNoMoreInteractions(caseSellerDaoMock);
		verify(saleDaoMock, times(1)).countBySellerAndStatus(cs,SaleStatus.DRAFT);
		verifyNoMoreInteractions(saleDaoMock);
	}
	
	@Test(expected = CaseSellerNotFoundException.class) 
	public void getSalesCountBySeller_SellerNotFound(){
		when(caseSellerDaoMock.findOne(1L)).thenReturn(null);
		saleService.getSalesCountBySeller(1L);
	}
	
	@Test
	public void getSalesCountBySeller_SellerFound(){
		CaseSeller cs = new StoreSeller();
		when(caseSellerDaoMock.findOne(1L)).thenReturn(cs);
		when(saleDaoMock.countBySeller(cs)).thenReturn(2L);
		Long result = saleService.getSalesCountBySeller(1L);
		assertTrue(result==2L);
		verify(caseSellerDaoMock, times(1)).findOne(1L);
		verifyNoMoreInteractions(caseSellerDaoMock);
		verify(saleDaoMock, times(1)).countBySeller(cs);
		verifyNoMoreInteractions(saleDaoMock);
	}

}
