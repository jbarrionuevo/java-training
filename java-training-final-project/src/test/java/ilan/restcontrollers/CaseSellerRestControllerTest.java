package ilan.restcontrollers;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

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

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import ilan.Application;
import ilan.dtos.CaseProductDTO;
import ilan.dtos.SaleDTO;
import ilan.exceptions.CaseSellerNotFoundException;
import ilan.models.Sale;
import ilan.services.CaseSellerService;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@ContextConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class CaseSellerRestControllerTest {

	@Mock
	private CaseSellerService caseSellerServiceMock;

	@Mock
	private Mapper mapper;

	@InjectMocks
	CaseSellerRestController caseSellerRestController;

	private MockMvc mockMvc;

	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	Gson gson = new Gson();

	Sale sale= new Sale();
	SaleDTO saleDTO=new SaleDTO();
	Collection<Sale> sales = new ArrayList<Sale>(Arrays.asList(sale));
	Collection<SaleDTO> dtoSales = new ArrayList<SaleDTO>(Arrays.asList(saleDTO));
	
	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(caseSellerRestController).build();
	}
	
	@Test
	public void addSale_CaseSellerNotFound() throws Exception {
		String jsonSale = gson.toJson(saleDTO);
		doThrow(new CaseSellerNotFoundException(1L)).when(caseSellerServiceMock).addSale(any(),any());
		mockMvc.perform(put("/caseSellers/1/addSale")
				.contentType(contentType)
		        .content(jsonSale))
				.andExpect(status().isNotFound());
		verify(caseSellerServiceMock, times(1)).addSale(any(),any());
		verifyZeroInteractions(caseSellerServiceMock);
	}
	
	@Test
	public void addSale_CaseSellerFound() throws Exception {
		String jsonSale = gson.toJson(saleDTO);
		mockMvc.perform(put("/caseSellers/1/addSale")
				.contentType(contentType)
		        .content(jsonSale))
				.andExpect(status().isOk());
		verify(caseSellerServiceMock, times(1)).addSale(any(),any());
		verifyZeroInteractions(caseSellerServiceMock);
	}
	
	@Test
	public void addSales_CaseSellerNotFound() throws Exception {
		String jsonSales = gson.toJson(dtoSales);
		doThrow(new CaseSellerNotFoundException(1L)).when(caseSellerServiceMock).addSales(any(),any());
		mockMvc.perform(put("/caseSellers/1/addSales")
				.contentType(contentType)
		        .content(jsonSales))
				.andExpect(status().isNotFound());
		verify(caseSellerServiceMock, times(1)).addSales(any(),any());
		verifyZeroInteractions(caseSellerServiceMock);
	}
	
	@Test
	public void addSales_CaseSellerFound() throws Exception {
		String jsonSales = gson.toJson(dtoSales);
		mockMvc.perform(put("/caseSellers/1/addSales")
				.contentType(contentType)
		        .content(jsonSales))
				.andExpect(status().isOk());
		verify(caseSellerServiceMock, times(1)).addSales(any(),any());
		verifyZeroInteractions(caseSellerServiceMock);
	}

}
