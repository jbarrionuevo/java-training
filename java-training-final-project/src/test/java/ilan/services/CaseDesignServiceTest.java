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
import ilan.daos.CaseDesignDao;
import ilan.exceptions.CaseDesignNotFoundException;
import ilan.models.CaseDesign;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@ContextConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class CaseDesignServiceTest {

	@Mock
	CaseDesignDao caseDesignDaoMock;
	
	@InjectMocks
	CaseDesignService caseDesignService;
	
	@Before
    public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void saveCaseDesign() throws Exception {
		CaseDesign newDesign = new CaseDesign("design");
		when(caseDesignDaoMock.save(newDesign)).thenReturn(newDesign);
		CaseDesign designReturned = caseDesignService.saveCaseDesign(newDesign);
		assertEquals(designReturned, newDesign);
	    verify(caseDesignDaoMock, times(1)).save(newDesign);
		verifyNoMoreInteractions(caseDesignDaoMock);
	}
	
	@Test
	public void saveCaseDesigns() throws Exception {
		CaseDesign newDesign = new CaseDesign("design");
		CaseDesign newDesign2 = new CaseDesign("design 2");
		CaseDesign newDesign3 = new CaseDesign("design 3");
		caseDesignService.saveCaseDesigns(newDesign,newDesign2,newDesign3);
	    verify(caseDesignDaoMock, times(3)).save(any(CaseDesign.class));
		verifyNoMoreInteractions(caseDesignDaoMock);
	}
	
	@Test(expected = CaseDesignNotFoundException.class) 
	public void findByName_CaseDesignNotFound() {
		when(caseDesignDaoMock.findByName("name")).thenReturn(null);
		caseDesignService.findByName("name");
	}
	
	@Test
	public void findByName_CaseDesignFound() {
		CaseDesign design = new CaseDesign("name");
		when(caseDesignDaoMock.findByName("name")).thenReturn(design);
		CaseDesign found = caseDesignService.findByName("name");
		assertEquals(design, found);
	    verify(caseDesignDaoMock, times(1)).findByName("name");
		verifyNoMoreInteractions(caseDesignDaoMock);
	}
	
	@Test
	public void findAllCaseDesigns() {
		CaseDesign design = new CaseDesign("name");
		CaseDesign design2 = new CaseDesign("design 2");
		CaseDesign design3 = new CaseDesign("design 3");
		when(caseDesignDaoMock.findAll()).thenReturn(Arrays.asList(design,design2,design3));
		Collection<CaseDesign> found = caseDesignService.findAllCaseDesignes();
		assertTrue(found.size()==3);
		assertTrue(found.containsAll(Arrays.asList(design,design2,design3)));
	    verify(caseDesignDaoMock, times(1)).findAll();
		verifyNoMoreInteractions(caseDesignDaoMock);
	}

}
