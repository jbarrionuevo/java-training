package ilan.restcontrollers;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

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
import ilan.exceptions.OrderAlertNotFoundException;
import ilan.exceptions.ProviderNotFoundException;
import ilan.models.CaseOrder;
import ilan.models.Customer;
import ilan.services.ProviderService;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@ContextConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class ProviderRestControllerTest {

	@Mock
	private ProviderService providerServiceMock;

	@Mock
	private Mapper mapper;
	
	@InjectMocks
	ProviderRestController providerRestController;

	private MockMvc mockMvc;
	
	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));
	
	Gson gson = new Gson();
	
	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(providerRestController).build();
	}
	
	@Test
	public void createOrder_ProviderNotFound() throws Exception {
		CaseOrder order = new CaseOrder();
		CaseOrderDTO orderDTO = new CaseOrderDTO();
		when(mapper.map(orderDTO, CaseOrder.class)).thenReturn(order);
		when(mapper.map(order, CaseOrderDTO.class)).thenReturn(orderDTO);
		doThrow(new ProviderNotFoundException(1L)).when(providerServiceMock).addOrder(any(),any(),any());
	    mockMvc.perform(post("/providers/1/orders")
	                .contentType(contentType)
	                .content(gson.toJson(orderDTO)))
	                .andExpect(status().isNotFound());
	}
	
	@Test
	public void createOrder_OrderalertNotFound() throws Exception {
		CaseOrder order = new CaseOrder();
		CaseOrderDTO orderDTO = new CaseOrderDTO();
		when(mapper.map(orderDTO, CaseOrder.class)).thenReturn(order);
		when(mapper.map(order, CaseOrderDTO.class)).thenReturn(orderDTO);
		doThrow(new OrderAlertNotFoundException(1L)).when(providerServiceMock).addOrder(any(),any(),any());
	    mockMvc.perform(post("/providers/1/orders?orderAlertId=1")
	                .contentType(contentType)
	                .content(gson.toJson(orderDTO)))
	                .andExpect(status().isNotFound());
	}
	
	@Test
	public void createOrder_AllFound() throws Exception {
		CaseOrder order = new CaseOrder();
		CaseOrderDTO orderDTO = new CaseOrderDTO();
		when(mapper.map(orderDTO, CaseOrder.class)).thenReturn(order);
		when(mapper.map(order, CaseOrderDTO.class)).thenReturn(orderDTO);
		 mockMvc.perform(post("/providers/1/orders?orderAlertId=1")
				.contentType(contentType)
		 		.content(gson.toJson(orderDTO)))
				.andExpect(status().isOk());
	}
	
	@Test
	public void getOrders_ProviderNotFound() throws Exception {
		CaseOrder order = new CaseOrder();
		CaseOrderDTO orderDTO = new CaseOrderDTO();
		when(mapper.map(orderDTO, CaseOrder.class)).thenReturn(order);
		when(mapper.map(order, CaseOrderDTO.class)).thenReturn(orderDTO);
		doThrow(new ProviderNotFoundException(1L)).when(providerServiceMock).getProviderOrders(any(),any());
		mockMvc.perform(get("/providers/1/orders")
	                .contentType(contentType)
	                .content(gson.toJson(orderDTO)))
	                .andExpect(status().isNotFound());
	}
	
	@Test
	public void getOrders() throws Exception {
		CaseOrderDTO orderDTO = new CaseOrderDTO(new HashMap<String,Integer>(),new Date());
		Collection<CaseOrderDTO> dtoorders = new ArrayList<CaseOrderDTO>(Arrays.asList(orderDTO));
		CaseOrder order = new CaseOrder(new HashMap<Long,Integer>(),new Date(),new Customer());
		Collection<CaseOrder> orders = new ArrayList<CaseOrder>(Arrays.asList(order));
		when(providerServiceMock.getProviderOrders(1L,"all")).thenReturn(orders);
		mockMvc.perform(get("/providers/1/orders"))
		.andExpect(status().isOk())
		.andExpect(content().contentType(contentType))
		.andExpect(jsonPath("$", hasSize(1)));
	}

}
