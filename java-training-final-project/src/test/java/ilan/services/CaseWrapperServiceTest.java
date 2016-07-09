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
import ilan.daos.CaseWrapperDao;
import ilan.models.CaseDesign;
import ilan.models.CaseWrapper;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@ContextConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class CaseWrapperServiceTest {

	@Mock
	CaseWrapperDao caseWrapperDaoMock;
	
	@InjectMocks
	CaseWrapperService caseWrapperService;
	
	@Before
    public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void saveCaseWrapper() throws Exception {
		CaseWrapper newWrapper = new CaseWrapper();
		when(caseWrapperDaoMock.save(newWrapper)).thenReturn(newWrapper);
		CaseWrapper WrapperReturned = caseWrapperService.saveCaseWrapper(newWrapper);
		assertEquals(WrapperReturned, newWrapper);
	    verify(caseWrapperDaoMock, times(1)).save(newWrapper);
		verifyNoMoreInteractions(caseWrapperDaoMock);
	}
	
	@Test
	public void saveCaseWrappers() throws Exception {
		CaseWrapper newWrapper = new CaseWrapper();
		CaseWrapper newWrapper2 = new CaseWrapper();
		CaseWrapper newWrapper3 = new CaseWrapper();
		caseWrapperService.saveCaseWrappers(newWrapper,newWrapper2,newWrapper3);
	    verify(caseWrapperDaoMock, times(3)).save(any(CaseWrapper.class));
		verifyNoMoreInteractions(caseWrapperDaoMock);
	}

}
