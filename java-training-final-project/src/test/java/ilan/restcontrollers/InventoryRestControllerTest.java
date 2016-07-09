package ilan.restcontrollers;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.util.Arrays;

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
import ilan.dtos.CaseProductDTO;
import ilan.dtos.CaseWrapperDTO;
import ilan.dtos.ProviderDTO;
import ilan.exceptions.CaseWrapperNotFoundException;
import ilan.exceptions.OrderNotFoundException;
import ilan.models.CaseDesign;
import ilan.models.CaseDevice;
import ilan.models.CaseProduct;
import ilan.models.CaseWrapper;
import ilan.models.Inventory;
import ilan.models.Provider;
import ilan.services.InventoryService;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@ContextConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class InventoryRestControllerTest {

	@Mock
	private InventoryService inventoryServiceMock;

	@Mock
	private Mapper mapper;
	
	@InjectMocks
	InventoryRestController inventoryRestController;

	private MockMvc mockMvc;
	
	CaseWrapper first,second;
	CaseWrapperDTO firstDTO,secondDTO;
	
	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));
	
	Gson gson = new Gson();
	
	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(inventoryRestController).build();
		Inventory inventory = new Inventory();
		CaseDevice dv1 = new CaseDevice("device");
		CaseDesign ds1 = new CaseDesign("design");
		CaseDevice dv2 = new CaseDevice("device 2");
		CaseDesign ds2 = new CaseDesign("design 2");
		CaseProduct p1 = new CaseProduct(ds1,dv1,100.5,new Provider("name","location"));
		CaseProduct p2 = new CaseProduct(ds2,dv2,200.5,new Provider("name 2","location 2"));
		first = new CaseWrapper(p1, 100, 100, inventory);
		second = new CaseWrapper(p2, 200, 200, inventory);
		CaseDeviceDTO dv1DTO = new CaseDeviceDTO("device");
		CaseDesignDTO ds1DTO = new CaseDesignDTO("design");
		CaseDeviceDTO dv2DTO = new CaseDeviceDTO("device 2");
		CaseDesignDTO ds2DTO = new CaseDesignDTO("design 2");
		CaseProductDTO p1DTO = new CaseProductDTO(ds1DTO,dv1DTO,100.5,new ProviderDTO("name","location"));
		CaseProductDTO p2DTO = new CaseProductDTO(ds2DTO,dv2DTO,200.5,new ProviderDTO("name 2","location 2"));
		firstDTO = new CaseWrapperDTO(p1DTO, 100, 100);
		secondDTO = new CaseWrapperDTO(p2DTO, 200, 200);
		when(mapper.map(first, CaseWrapperDTO.class)).thenReturn(firstDTO);
		when(mapper.map(second, CaseWrapperDTO.class)).thenReturn(secondDTO);
	}
	
	@Test
	public void getInventoryWithDesignAndDeviceOnlyWithDesignSpecified() throws Exception {
		when(inventoryServiceMock.getInventoryWithDesignAndDevice("design","all",0,5)).thenReturn(Arrays.asList(first, second));
		mockMvc.perform(get("/inventory?design=design&device=all"))
		.andExpect(status().isOk())
		.andExpect(content().contentType(contentType))
		.andExpect(jsonPath("$", hasSize(2)))
		.andExpect(jsonPath("$[0].minimumStock", is(firstDTO.getMinimumStock())))
		.andExpect(jsonPath("$[0].currentStock", is(firstDTO.getCurrentStock())))
		.andExpect(jsonPath("$[1].minimumStock", is(secondDTO.getMinimumStock())))
		.andExpect(jsonPath("$[1].currentStock", is(secondDTO.getCurrentStock())));
	}
	
	@Test
	public void getInventoryWithDesignAndDeviceOnlyWithDeviceSpecified() throws Exception {
		when(inventoryServiceMock.getInventoryWithDesignAndDevice("all","device",0,5)).thenReturn(Arrays.asList(first, second));
		mockMvc.perform(get("/inventory?design=all&device=device"))
		.andExpect(status().isOk())
		.andExpect(content().contentType(contentType))
		.andExpect(jsonPath("$", hasSize(2)))
		.andExpect(jsonPath("$[0].minimumStock", is(firstDTO.getMinimumStock())))
		.andExpect(jsonPath("$[0].currentStock", is(firstDTO.getCurrentStock())))
		.andExpect(jsonPath("$[1].minimumStock", is(secondDTO.getMinimumStock())))
		.andExpect(jsonPath("$[1].currentStock", is(secondDTO.getCurrentStock())));
	}
	
	@Test
	public void getInventoryWithDesignAndDeviceWithDeviceAndDesignSpecified() throws Exception {
		when(inventoryServiceMock.getInventoryWithDesignAndDevice("design","device",0,5)).thenReturn(Arrays.asList(first, second));
		mockMvc.perform(get("/inventory?design=design&device=device"))
		.andExpect(status().isOk())
		.andExpect(content().contentType(contentType))
		.andExpect(jsonPath("$", hasSize(2)))
		.andExpect(jsonPath("$[0].minimumStock", is(firstDTO.getMinimumStock())))
		.andExpect(jsonPath("$[0].currentStock", is(firstDTO.getCurrentStock())))
		.andExpect(jsonPath("$[1].minimumStock", is(secondDTO.getMinimumStock())))
		.andExpect(jsonPath("$[1].currentStock", is(secondDTO.getCurrentStock())));
	}
	
	@Test
	public void getInventoryWrappers() throws Exception {
		when(inventoryServiceMock.getAllInventoryWrappers()).thenReturn(Arrays.asList(first, second));
		mockMvc.perform(get("/inventory/wrappers"))
		.andExpect(status().isOk())
		.andExpect(content().contentType(contentType))
		.andExpect(jsonPath("$", hasSize(2)))
		.andExpect(jsonPath("$[0].minimumStock", is(firstDTO.getMinimumStock())))
		.andExpect(jsonPath("$[0].currentStock", is(firstDTO.getCurrentStock())))
		.andExpect(jsonPath("$[1].minimumStock", is(secondDTO.getMinimumStock())))
		.andExpect(jsonPath("$[1].currentStock", is(secondDTO.getCurrentStock())));
	}

	@Test
	public void getCount() throws Exception {
		when(inventoryServiceMock.getCount("design","device")).thenReturn(2L);
		mockMvc.perform(get("/inventory/count?design=design&device=device"))
		.andExpect(status().isOk())
		.andExpect(content().contentType(contentType))
		.andExpect(jsonPath("$", is(2)));
	}
	
	@Test
	public void supply_OrderNotFound() throws Exception {
		doThrow(new OrderNotFoundException(1L)).when(inventoryServiceMock).supplyStock(1L);
		mockMvc.perform(put("/inventory/supply/1")
				.contentType(contentType))
				.andExpect(status().isNotFound());
	}
	
	@Test
	public void supply_OrderFound() throws Exception {
		mockMvc.perform(put("/inventory/supply/1")
				.contentType(contentType))
				.andExpect(status().isOk());
	}
	
	@Test
	public void updateCaseWrapperMinimumStock_CaseWrapperNotFound() throws Exception {
		doThrow(new CaseWrapperNotFoundException(1L)).when(inventoryServiceMock).updateCaseWrapper(1L,100);
		mockMvc.perform(put("/inventory/caseWrappers/1/minimumStock/100")
				.contentType(contentType))
				.andExpect(status().isNotFound());
	}
	
	@Test
	public void updateCaseWrapperMinimumStock_CaseWrapperFound() throws Exception {
		mockMvc.perform(put("/inventory/caseWrappers/1/minimumStock/100")
				.contentType(contentType))
				.andExpect(status().isOk());
	}
	
}
