package ilan.controllers;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

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
import ilan.exceptions.ProviderNotFoundException;
import ilan.models.CaseOrder;
import ilan.models.Provider;
import ilan.services.ProviderService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@ContextConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class ProviderControllerTest {

	@Mock
	private ProviderService providerServiceMock;

	@InjectMocks
	ProviderController providerController;

	private MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(providerController).build();
	}

	@Test
	public void findById_ProviderNotFound_ShouldThrowError() throws Exception {
		when(providerServiceMock.getProviderOrders(1L,"false")).thenThrow(new ProviderNotFoundException(1L));

		mockMvc.perform(get("/providersView/{providerId}/orders", 1L))
				.andExpect(status().isNotFound());

		verify(providerServiceMock, times(1)).getProviderOrders(1L,"false");
		verifyZeroInteractions(providerServiceMock);
	}
	
	@Test
	public void findById_ProviderFound_ShouldAddProviderOrdersToModelAndRenderProviderView() throws Exception {
		Provider p1 = new Provider("provider", "location");
		Collection<CaseOrder> orders = new ArrayList<CaseOrder>(
												Arrays.asList(
														new CaseOrder(new HashMap<Long,Integer>(), new Date(), p1),
														new CaseOrder(new HashMap<Long,Integer>(), new Date(), p1)));	
		p1.setOrders(orders);
		when(providerServiceMock.getProviderOrders(1L,"false")).thenReturn(orders);

		mockMvc.perform(get("/providersView/{providerId}/orders", 1L))
				.andExpect(status().isOk())
				.andExpect(view().name("provider"))
				.andExpect(model().attribute("orders", hasSize(2)))
				.andExpect(model().attribute("orders",hasItem(allOf(hasProperty("thirdPartyParticipant", is(p1))))));

		verify(providerServiceMock, times(1)).getProviderOrders(1L,"false");
		verifyNoMoreInteractions(providerServiceMock);
	}

	@Test
	public void getProviders_ShouldAddProvidersToModelAndRenderProvidersView() throws Exception {
		Provider p1 = new Provider("provider", "location");
		Provider p2 = new Provider("provider 2", "location 2");
		when(providerServiceMock.findAllProviders()).thenReturn(Arrays.asList(p1, p2));
		mockMvc.perform(get("/providersView"))
				.andExpect(status().isOk())
				.andExpect(view().name("providers"))
				.andExpect(model().attribute("providers", hasSize(2)))
				.andExpect(model().attribute("providers",
						hasItem(allOf(hasProperty("name", is("provider")), hasProperty("location", is("location"))))))
				.andExpect(model().attribute("providers", hasItem(
						allOf(hasProperty("name", is("provider 2")), hasProperty("location", is("location 2"))))));

		verify(providerServiceMock, times(1)).findAllProviders();
		verifyNoMoreInteractions(providerServiceMock);
	}

}
