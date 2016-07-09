package ilan.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
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
import ilan.daos.CaseSellerDao;
import ilan.daos.CaseWrapperDao;
import ilan.daos.CustomerDao;
import ilan.enums.SaleStatus;
import ilan.exceptions.CaseDesignNotFoundException;
import ilan.exceptions.CaseProductNotFoundException;
import ilan.exceptions.CaseSellerNotFoundException;
import ilan.exceptions.CustomerNotFoundException;
import ilan.models.CaseDesign;
import ilan.models.CaseOrder;
import ilan.models.CaseSeller;
import ilan.models.CaseWrapper;
import ilan.models.Customer;
import ilan.models.Receipt;
import ilan.models.Sale;
import ilan.models.StoreSeller;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@ContextConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class CaseSellerServiceTest {

	@Mock
	CaseSellerDao caseSellerDaoMock;
	@Mock
	CustomerDao customerDaoMock;
	@Mock
	CaseWrapperDao caseWrapperDaoMock;
	@Mock
	CaseOrderDao caseOrderDaoMock;
	
	@InjectMocks
	CaseSellerService caseSellerServiceMock;
	
	@Before
    public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void saveCaseSeller() throws Exception {
		CaseSeller newSeller = new StoreSeller("name","store");
		when(caseSellerDaoMock.save(newSeller)).thenReturn(newSeller);
		CaseSeller sellerReturned = caseSellerServiceMock.save(newSeller);
		assertEquals(sellerReturned, newSeller);
	    verify(caseSellerDaoMock, times(1)).save(newSeller);
		verifyNoMoreInteractions(caseSellerDaoMock);
	}
	
	@Test(expected = CaseSellerNotFoundException.class) 
	public void addSale_CaseSellerNotFound() throws Exception {
		when(caseSellerDaoMock.findOne(1L)).thenReturn(null);
		caseSellerServiceMock.addSale(1L, new Sale());
	}
	
	@Test(expected = CustomerNotFoundException.class) 
	public void addSale_CustomerNotFound() throws Exception {
		when(caseSellerDaoMock.findOne(1L)).thenReturn(new StoreSeller());
		when(customerDaoMock.findOne(1L)).thenReturn(null);
		Customer customer = new Customer();
		customer.setId(1L);
		caseSellerServiceMock.addSale(1L, new Sale(new CaseOrder(), new ArrayList<Receipt>(Arrays.asList(new Receipt("store", new Date(), customer))),100.5,SaleStatus.DRAFT));
	}
	
	@Test(expected = CaseProductNotFoundException.class) 
	public void addSale_CaseProductNotFound() throws Exception {
		when(caseSellerDaoMock.findOne(1L)).thenReturn(new StoreSeller());
		when(customerDaoMock.findOne(1L)).thenReturn(new Customer());
		when(caseWrapperDaoMock.findByMyCaseId(1L)).thenReturn(null);
		CaseOrder order = new CaseOrder(new HashMap<Long,Integer>(){{put(1L, 41);}},new Date(), new Customer());
		caseSellerServiceMock.addSale(1L, new Sale(order, new ArrayList<Receipt>(Arrays.asList(new Receipt("store", new Date(), new Customer()))),100.5,SaleStatus.DRAFT));
	}
	
	@Test
	public void addSale_AllFound() throws Exception {
		when(caseSellerDaoMock.findOne(1L)).thenReturn(new StoreSeller("name","store"));
		when(customerDaoMock.findOne(1L)).thenReturn(new Customer());
		when(caseWrapperDaoMock.findByMyCaseId(1L)).thenReturn(new CaseWrapper());
		CaseOrder order = new CaseOrder(new HashMap<Long,Integer>(){{put(1L, 41);}},new Date(), new Customer());
		caseSellerServiceMock.addSale(1L, new Sale(order, new ArrayList<Receipt>(Arrays.asList(new Receipt("store", new Date(), new Customer()))),100.5,SaleStatus.DRAFT));
	}
	
	
	@Test
	public void addSales() throws Exception {
		when(caseSellerDaoMock.findOne(1L)).thenReturn(new StoreSeller("name","store"));
		when(customerDaoMock.findOne(1L)).thenReturn(new Customer());
		when(caseWrapperDaoMock.findByMyCaseId(1L)).thenReturn(new CaseWrapper());
		CaseOrder order = new CaseOrder(new HashMap<Long,Integer>(){{put(1L, 41);}},new Date(), new Customer());
		Sale sale1 = new Sale(order, new ArrayList<Receipt>(Arrays.asList(new Receipt("store", new Date(), new Customer()))),100.5,SaleStatus.DRAFT);
		Sale sale2 = new Sale(order, new ArrayList<Receipt>(Arrays.asList(new Receipt("store", new Date(), new Customer()))),100.5,SaleStatus.DRAFT);
		caseSellerServiceMock.addSales(1L,Arrays.asList(sale1,sale2));
	}

}
