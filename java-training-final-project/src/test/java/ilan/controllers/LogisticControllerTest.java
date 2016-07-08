package ilan.controllers;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Arrays;

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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import ilan.Application;
import ilan.models.CaseDesign;
import ilan.models.CaseDevice;
import ilan.models.CaseProduct;
import ilan.models.OrderAlert;
import ilan.models.Provider;
import ilan.services.InventoryService;
import ilan.services.OrderAlertService;
import ilan.services.ProviderService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@ContextConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class LogisticControllerTest {

	@Mock
	private InventoryService inventoryServiceMock;
	@Mock
	private ProviderService providerServiceMock;
	@Mock
	private OrderAlertService orderAlertServiceMock;

	@InjectMocks
	LogisticController logisticController;

	private MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(logisticController).build();
	}

	@Test
	public void logisticIndex_ShouldAddProvidersAndDesignsAndDevicesAndNotMadeAlertsToModelAndRenderLogisticView()
			throws Exception {
		CaseDevice dv1 = new CaseDevice("device");
		CaseDesign ds1 = new CaseDesign("design");
		CaseDevice dv2 = new CaseDevice("device 2");
		CaseDesign ds2 = new CaseDesign("design 2");
		Provider p1 = new Provider("provider", "location");
		Provider p2 = new Provider("provider 2", "location 2");
		CaseProduct cp1 = new CaseProduct(ds1, dv1, 10.5, p1);
		CaseProduct cp2 = new CaseProduct(ds2, dv2, 21.5, p2);
		OrderAlert o1 = new OrderAlert(10, cp1);
		OrderAlert o2 = new OrderAlert(15, cp2);
		when(inventoryServiceMock.getDesigns()).thenReturn(Arrays.asList(ds1, ds2));
		when(inventoryServiceMock.getDevices()).thenReturn(Arrays.asList(dv1, dv2));
		when(providerServiceMock.findAllProviders(0, 5)).thenReturn(Arrays.asList(p1,p2));
		when(orderAlertServiceMock.findNotMadeAlerts()).thenReturn(Arrays.asList(o1, o2));
		mockMvc.perform(get("/logisticView"))
				.andExpect(status().isOk())
				.andExpect(view().name("logistic"))
				.andExpect(model().attribute("designs", hasSize(2)))
				.andExpect(model().attribute("designs", hasItem(allOf(hasProperty("name", is("design"))))))
				.andExpect(model().attribute("designs", hasItem(allOf(hasProperty("name", is("design 2"))))))
				.andExpect(model().attribute("devices", hasSize(2)))
				.andExpect(model().attribute("devices", hasItem(allOf(hasProperty("name", is("device"))))))
				.andExpect(model().attribute("devices", hasItem(allOf(hasProperty("name", is("device 2"))))))
				.andExpect(model().attribute("providers", hasSize(2)))
				.andExpect(model().attribute("providers", hasItem(allOf(hasProperty("name", is("provider")),hasProperty("location", is("location"))))))
				.andExpect(model().attribute("providers", hasItem(allOf(hasProperty("name", is("provider 2")),hasProperty("location", is("location 2"))))))
				.andExpect(model().attribute("alerts", hasSize(2)))
				.andExpect(model().attribute("alerts", hasItem(allOf(hasProperty("quantity", is(10)),hasProperty("product", is(cp1))))))
				.andExpect(model().attribute("alerts", hasItem(allOf(hasProperty("quantity", is(15)),hasProperty("product", is(cp2))))));

		verify(inventoryServiceMock, times(1)).getDesigns();
		verify(inventoryServiceMock, times(1)).getDevices();
		verifyNoMoreInteractions(inventoryServiceMock);
		verify(providerServiceMock, times(1)).findAllProviders(0,5);
		verifyNoMoreInteractions(providerServiceMock);
		verify(orderAlertServiceMock, times(1)).findNotMadeAlerts();
		verifyNoMoreInteractions(orderAlertServiceMock);
		
	}

}
