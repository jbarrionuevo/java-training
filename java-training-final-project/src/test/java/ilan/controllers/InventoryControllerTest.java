package ilan.controllers;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import ilan.Application;
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
public class InventoryControllerTest {

	@Mock
	private InventoryService inventoryServiceMock;
	
	@InjectMocks
	InventoryController inventoryController;
	
	private MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mockMvc= MockMvcBuilders.standaloneSetup(inventoryController).build();	
	}

	@Test
	public void getInventory_ShouldAddCaseWrappersAndDesignsAndDevicesAndPageQuantityToModelAndRenderInventoryView() throws Exception {
		Inventory inventory = new Inventory();
		CaseDevice dv1 = new CaseDevice("device");
		CaseDesign ds1 = new CaseDesign("design");
		CaseDevice dv2 = new CaseDevice("device 2");
		CaseDesign ds2 = new CaseDesign("design 2");
		CaseProduct p1 = new CaseProduct(ds1,dv1,100.5,new Provider("name","location"));
		CaseProduct p2 = new CaseProduct(ds2,dv2,200.5,new Provider("name 2","location 2"));
		CaseWrapper first = new CaseWrapper(p1, 100, 100, inventory);
		CaseWrapper second = new CaseWrapper(p2, 200, 200, inventory);
        when(inventoryServiceMock.getInventoryWrappers(0,5)).thenReturn(Arrays.asList(first, second));
        when(inventoryServiceMock.getDesigns()).thenReturn(Arrays.asList(ds1, ds2));
        when(inventoryServiceMock.getDevices()).thenReturn(Arrays.asList(dv1, dv2));
        when(inventoryServiceMock.getInventoryCount()).thenReturn(2L);
        mockMvc.perform(get("/inventoryView"))
				.andExpect(status().isOk())
				.andExpect(view().name("inventory"))
				.andExpect(model().attribute("designs", hasSize(2)))
				.andExpect(model().attribute("designs", hasItem(allOf(hasProperty("name", is("design"))))))
				.andExpect(model().attribute("designs", hasItem(allOf(hasProperty("name", is("design 2"))))))
				.andExpect(model().attribute("devices", hasSize(2)))
				.andExpect(model().attribute("devices", hasItem(allOf(hasProperty("name", is("device"))))))
				.andExpect(model().attribute("devices", hasItem(allOf(hasProperty("name", is("device 2"))))))
				.andExpect(model().attribute("pageQuantity", is(1L)))
				.andExpect(model().attribute("inventory", hasSize(2)))
		        .andExpect(model().attribute("inventory", hasItem(
		                allOf(
		                        hasProperty("minimumStock", is(100)),
		                        hasProperty("currentStock", is(100)),
		                        hasProperty("myCase", is(p1)),
		                        hasProperty("inventory", is(inventory))
		                )
		        )))
		        .andExpect(model().attribute("inventory", hasItem(
		                allOf(
		                        hasProperty("minimumStock", is(200)),
		                        hasProperty("currentStock", is(200)),
		                        hasProperty("myCase", is(p2)),
		                        hasProperty("inventory", is(inventory))
		                )
		        )));

		 verify(inventoryServiceMock, times(1)).getInventoryWrappers(0,5);
		 verify(inventoryServiceMock, times(1)).getDesigns();
		 verify(inventoryServiceMock, times(1)).getDevices();
		 verify(inventoryServiceMock, times(1)).getInventoryCount();
		 verifyNoMoreInteractions(inventoryServiceMock);
	}
	
	@Test
	public void getInventoryWrappers_ShouldAddCaseWrappersToModelAndRenderUpdateStocksView() throws Exception {
		Inventory inventory = new Inventory();
		CaseProduct p1 = new CaseProduct(new CaseDesign("design"),new CaseDevice("device"),100.5,new Provider("name","location"));
		CaseProduct p2 = new CaseProduct(new CaseDesign("design 2"),new CaseDevice("device 2"),200.5,new Provider("name 2","location 2"));
		CaseWrapper first = new CaseWrapper(p1, 100, 100, inventory);
		CaseWrapper second = new CaseWrapper(p2, 200, 200, inventory);
        when(inventoryServiceMock.getAllInventoryWrappers()).thenReturn(Arrays.asList(first, second));
		mockMvc.perform(get("/inventoryView/wrappers"))
				.andExpect(status().isOk())
				.andExpect(view().name("updateStocks"))
				.andExpect(model().attribute("inventory", hasSize(2)))
                .andExpect(model().attribute("inventory", hasItem(
                        allOf(
                                hasProperty("minimumStock", is(100)),
                                hasProperty("currentStock", is(100)),
                                hasProperty("myCase", is(p1)),
                                hasProperty("inventory", is(inventory))
                        )
                )))
                .andExpect(model().attribute("inventory", hasItem(
                        allOf(
                                hasProperty("minimumStock", is(200)),
                                hasProperty("currentStock", is(200)),
                                hasProperty("myCase", is(p2)),
                                hasProperty("inventory", is(inventory))
                        )
                )));
		
		 verify(inventoryServiceMock, times(1)).getAllInventoryWrappers();
	     verifyNoMoreInteractions(inventoryServiceMock);
	}

}
