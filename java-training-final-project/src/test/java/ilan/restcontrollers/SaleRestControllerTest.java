package ilan.restcontrollers;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
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
import java.util.Date;

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
import ilan.dtos.CaseDesignDTO;
import ilan.dtos.CaseDeviceDTO;
import ilan.dtos.CaseOrderDTO;
import ilan.dtos.CaseProductDTO;
import ilan.dtos.CustomerDTO;
import ilan.dtos.ProviderDTO;
import ilan.dtos.ReceiptDTO;
import ilan.dtos.SaleDTO;
import ilan.enums.Gender;
import ilan.enums.SaleStatus;
import ilan.exceptions.CaseProductNotFoundException;
import ilan.exceptions.CaseSellerNotFoundException;
import ilan.exceptions.ProviderNotFoundException;
import ilan.exceptions.SaleNotFoundException;
import ilan.models.CaseDesign;
import ilan.models.CaseDevice;
import ilan.models.CaseOrder;
import ilan.models.CaseProduct;
import ilan.models.Customer;
import ilan.models.Provider;
import ilan.models.Receipt;
import ilan.models.Sale;
import ilan.services.SaleService;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@ContextConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class SaleRestControllerTest {

	@Mock
	private SaleService saleServiceMock;

	@Mock
	private Mapper mapper;
	
	@InjectMocks
	SaleRestController saleRestController;

	private MockMvc mockMvc;
	
	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));
	
	Gson gson = new Gson();
	
	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(saleRestController).build();
	}
	
	@Test
	public void saveSale() throws Exception {
		Sale sale= new Sale();
		SaleDTO saleDTO = new SaleDTO();
	    when(saleServiceMock.save(any())).thenReturn(sale);
		when(mapper.map(saleDTO, Sale.class)).thenReturn(sale);
		when(mapper.map(sale, SaleDTO.class)).thenReturn(saleDTO);
	    mockMvc.perform(post("/sales")
	                .contentType(contentType)
	                .content(gson.toJson(saleDTO)))
	                .andExpect(status().isCreated());
	    
	    verify(saleServiceMock, times(1)).save(any());
		verifyNoMoreInteractions(saleServiceMock);
	}
	
	@Test
	public void getSale_SaleNotFound() throws Exception {
		when(saleServiceMock.getSale(1L)).thenThrow(new SaleNotFoundException(1L));
		mockMvc.perform(get("/sales/1"))
				.andExpect(status().isNotFound());;
				
		verify(saleServiceMock, times(1)).getSale(1L);
		verifyZeroInteractions(saleServiceMock);
	}
	
	@Test
	public void getSale_ProductFound() throws Exception {
		SaleDTO s1dto = new SaleDTO(new CaseOrderDTO(), new ArrayList<ReceiptDTO>(), 100.5, SaleStatus.DRAFT);
		Sale s1 = new Sale(new CaseOrder(), new ArrayList<Receipt>(), 100, SaleStatus.DRAFT);
		when(saleServiceMock.getSale(1L)).thenReturn(s1);
		when(mapper.map(s1, SaleDTO.class)).thenReturn(s1dto);
		mockMvc.perform(get("/sales/1"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(contentType))
				.andExpect(jsonPath("$.totalPrice", is(s1dto.getTotalPrice())))
				.andExpect(jsonPath("$.status", is("DRAFT")));
		
		verify(saleServiceMock, times(1)).getSale(1L);
		verifyNoMoreInteractions(saleServiceMock);
	}
	
	@Test
	public void updateStatus_SaleNotFound() throws Exception {
		doThrow(new SaleNotFoundException(1L)).when(saleServiceMock).update(any(),any());
		mockMvc.perform(put("/sales/1?status=paid"))
				.andExpect(status().isNotFound());;
				
		verify(saleServiceMock, times(1)).update(any(),any());
		verifyZeroInteractions(saleServiceMock);
	}
	
	@Test
	public void updateStatus_SaleFound() throws Exception {
		mockMvc.perform(put("/sales/1?status=paid"))
				.andExpect(status().isOk());
				
		verify(saleServiceMock, times(1)).update(any(),any());
		verifyZeroInteractions(saleServiceMock);
	}

	@Test
	public void getSaleReceipt_SaleNotFound() throws Exception {
		doThrow(new SaleNotFoundException(1L)).when(saleServiceMock).getSaleReceipt(1L);
		mockMvc.perform(get("/sales/1/receipt"))
				.andExpect(status().isNotFound());;
				
		verify(saleServiceMock, times(1)).getSaleReceipt(1L);
		verifyZeroInteractions(saleServiceMock);
	}
	
	@Test
	public void getSaleReceipt_SaleFound() throws Exception {
		Receipt r = new Receipt("store", new Date(), new Customer("ilan","location",23,Gender.M));
		ReceiptDTO rDTO = new ReceiptDTO("store DTO", new Date(), new CustomerDTO("ilan","location",23,Gender.M));
		when(saleServiceMock.getSaleReceipt(1L)).thenReturn(r);
		when(mapper.map(r, ReceiptDTO.class)).thenReturn(rDTO);
		mockMvc.perform(get("/sales/1/receipt"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(contentType))
				.andExpect(jsonPath("$.storeName", is(rDTO.getStoreName())))
				.andExpect(jsonPath("$.customer.name", is(rDTO.getCustomer().getName())))
				.andExpect(jsonPath("$.customer.location", is(rDTO.getCustomer().getLocation())))
				.andExpect(jsonPath("$.customer.age", is(rDTO.getCustomer().getAge())))
				.andExpect(jsonPath("$.customer.gender", is(rDTO.getCustomer().getGender().toString())));
				
		verify(saleServiceMock, times(1)).getSaleReceipt(1L);
		verifyZeroInteractions(saleServiceMock);
	}

	@Test
	public void getSalesCountWithStatus_SellerNotFound() throws Exception {
		doThrow(new CaseSellerNotFoundException(1L)).when(saleServiceMock).getCount(1L,"paid");
		mockMvc.perform(get("/sales/seller/1/count?status=paid"))
				.andExpect(status().isNotFound());;
				
		verify(saleServiceMock, times(1)).getCount(1L,"paid");
		verifyZeroInteractions(saleServiceMock);
	}
	
	@Test
	public void getSalesCountWithStatus_SaleFound() throws Exception {
		when(saleServiceMock.getCount(1L, "paid")).thenReturn(2L);
		mockMvc.perform(get("/sales/seller/1/count?status=paid"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", is(2)));
				
		verify(saleServiceMock, times(1)).getCount(1L,"paid");
		verifyZeroInteractions(saleServiceMock);
	}
	
	@Test
	public void getSalesFromCaseSeller_SellerNotFound() throws Exception {
		doThrow(new CaseSellerNotFoundException(1L)).when(saleServiceMock).getSalesFromCaseSeller(1L,"paid",0,5);
		mockMvc.perform(get("/sales/seller/1?status=paid"))
				.andExpect(status().isNotFound());;
				
		verify(saleServiceMock, times(1)).getSalesFromCaseSeller(1L,"paid",0,5);
		verifyZeroInteractions(saleServiceMock);
	}
	
	@Test
	public void getSalesFromCaseSeller_SellerFound() throws Exception {
		SaleDTO s1dto = new SaleDTO(new CaseOrderDTO(), new ArrayList<ReceiptDTO>(), 100.5, SaleStatus.PAID);
		Sale s1 = new Sale(new CaseOrder(), new ArrayList<Receipt>(), 100, SaleStatus.PAID);
		when(mapper.map(s1, SaleDTO.class)).thenReturn(s1dto);
		when(saleServiceMock.getSalesFromCaseSeller(1L,"paid",0,5)).thenReturn(Arrays.asList(s1));
		mockMvc.perform(get("/sales/seller/1?status=paid"))
		.andExpect(status().isOk())
		.andExpect(content().contentType(contentType))
		.andExpect(jsonPath("$", hasSize(1)))
		.andExpect(jsonPath("$[0].totalPrice", is(s1dto.getTotalPrice())))
		.andExpect(jsonPath("$[0].status", is(s1dto.getStatus().toString())));
	}
	
}
