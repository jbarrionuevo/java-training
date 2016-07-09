package ilan.services;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ilan.daos.CaseDesignDao;
import ilan.daos.CaseProductDao;
import ilan.models.CaseDesign;
import ilan.models.CaseDevice;
import ilan.models.CaseProduct;
import ilan.models.Provider;

public class CaseProductServiceTest {

	@Mock
	CaseProductDao caseProductDaoMock;
	
	@InjectMocks
	CaseProductService cartProductService;
	
	@Before
    public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void saveCaseProduct() throws Exception {
		CaseProduct newProduct = new CaseProduct(new CaseDesign("design"),new CaseDevice("device"),100.5,new Provider("name","location"));
		when(caseProductDaoMock.save(newProduct)).thenReturn(newProduct);
		CaseProduct ProductReturned = cartProductService.saveCase(newProduct);
		assertEquals(ProductReturned, newProduct);
	    verify(caseProductDaoMock, times(1)).save(newProduct);
		verifyNoMoreInteractions(caseProductDaoMock);
	}
	
	@Test
	public void saveCaseProducts() throws Exception {
		CaseProduct newProduct = new CaseProduct(new CaseDesign("design"),new CaseDevice("device"),100.5,new Provider("name","location"));
		CaseProduct newProduct2 = new CaseProduct(new CaseDesign("design2"),new CaseDevice("device2"),100.5,new Provider("name2","location2"));
		CaseProduct newProduct3 = new CaseProduct(new CaseDesign("design3"),new CaseDevice("device3"),100.5,new Provider("name3","location3"));
		cartProductService.saveCases(newProduct,newProduct2,newProduct3);
	    verify(caseProductDaoMock, times(3)).save(any(CaseProduct.class));
		verifyNoMoreInteractions(caseProductDaoMock);
	}
	
	@Test
	public void findAllCases() {
		CaseProduct newProduct = new CaseProduct(new CaseDesign("design"),new CaseDevice("device"),100.5,new Provider("name","location"));
		CaseProduct newProduct2 = new CaseProduct(new CaseDesign("design2"),new CaseDevice("device2"),100.5,new Provider("name2","location2"));
		CaseProduct newProduct3 = new CaseProduct(new CaseDesign("design3"),new CaseDevice("device3"),100.5,new Provider("name3","location3"));
		when(caseProductDaoMock.findAll()).thenReturn(Arrays.asList(newProduct,newProduct2,newProduct3));
		Collection<CaseProduct> found = cartProductService.findAllCases();
		assertTrue(found.size()==3);
		assertTrue(found.containsAll(Arrays.asList(newProduct,newProduct2,newProduct3)));
	    verify(caseProductDaoMock, times(1)).findAll();
		verifyNoMoreInteractions(caseProductDaoMock);
	}
	
	@Test
	public void findCasesWithDesign() {
		CaseDesign design = new CaseDesign("design");
		CaseProduct newProduct = new CaseProduct(design,new CaseDevice("device"),100.5,new Provider("name","location"));
		CaseProduct newProduct2 = new CaseProduct(design,new CaseDevice("device2"),100.5,new Provider("name2","location2"));
		CaseProduct newProduct3 = new CaseProduct(design,new CaseDevice("device3"),100.5,new Provider("name3","location3"));
		when(caseProductDaoMock.findByDesign(design)).thenReturn(Arrays.asList(newProduct,newProduct2,newProduct3));
		Collection<CaseProduct> found = cartProductService.findCasesWithDesign(design);
		assertTrue(found.size()==3);
		assertTrue(found.containsAll(Arrays.asList(newProduct,newProduct2,newProduct3)));
	    verify(caseProductDaoMock, times(1)).findByDesign(design);
		verifyNoMoreInteractions(caseProductDaoMock);
	}
	
	@Test
	public void findCasesWithDesignAndDevice() {
		CaseDesign design = new CaseDesign("design");
		CaseDevice device = new CaseDevice("device");
		CaseProduct newProduct = new CaseProduct(design,device,100.5,new Provider("name","location"));
		when(caseProductDaoMock.findByDesignNameAndDeviceName("design","device")).thenReturn(newProduct);
		CaseProduct found = cartProductService.findCaseWithDesignAndDevice("design","device");
		assertEquals(found, newProduct);
	    verify(caseProductDaoMock, times(1)).findByDesignNameAndDeviceName("design","device");
		verifyNoMoreInteractions(caseProductDaoMock);
	}

}
