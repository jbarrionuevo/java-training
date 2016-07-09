package ilan.restcontrollers;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

import org.dozer.Mapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.google.gson.Gson;

import ilan.Application;
import ilan.dtos.CaseOrderDTO;
import ilan.models.CaseOrder;
import ilan.services.CaseOrderService;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@ContextConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class CaseOrderRestControllerTest {

	@Mock
	private CaseOrderService caseOrderServiceMock;

	@Mock
	private Mapper mapper;
	
	@InjectMocks
	CaseOrderRestController caseOrderRestController;

	private MockMvc mockMvc;
	
	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));
	
	Gson gson = new Gson();
	
	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(caseOrderRestController).build();
	}
	
	@Test
	public void saveCaseOrder() throws Exception {
		CaseOrder order = new CaseOrder();
		CaseOrderDTO orderDTO = new CaseOrderDTO();
	    when(caseOrderServiceMock.save(any())).thenReturn(order);
		when(mapper.map(orderDTO, CaseOrder.class)).thenReturn(order);
		when(mapper.map(order, CaseOrderDTO.class)).thenReturn(orderDTO);
	    mockMvc.perform(post("/orders")
	                .contentType(contentType)
	                .content(gson.toJson(orderDTO)))
	                .andExpect(status().isCreated());
	    
	    verify(caseOrderServiceMock, times(1)).save(any());
		verifyNoMoreInteractions(caseOrderServiceMock);
	}
	

}
