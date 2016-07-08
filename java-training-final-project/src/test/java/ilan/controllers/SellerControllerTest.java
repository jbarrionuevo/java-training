package ilan.controllers;

import static org.hamcrest.Matchers.hasSize;
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

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.junit.Test;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import ilan.exceptions.CaseSellerNotFoundException;
import ilan.exceptions.ProviderNotFoundException;
import ilan.models.Sale;
import ilan.services.InventoryService;
import ilan.services.SaleService;

public class SellerControllerTest {

	@Mock
	private SaleService saleServiceMock;
	@Mock
	private InventoryService inventoryServiceMock;
	
	@InjectMocks
	SellerController SellerController;
	
	private MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mockMvc= MockMvcBuilders.standaloneSetup(SellerController).build();	
	}
	
	@Test
	public void getSalesFromCaseSeller_CaseSellerNotFound_ShouldRenderThrowError() throws Exception {
		when(saleServiceMock.getSalesFromCaseSeller(1L,"all",0,5)).thenThrow(new CaseSellerNotFoundException(1L));
		mockMvc.perform(get("/sellersView/seller/1/sales"))
				.andExpect(status().isNotFound());

		verify(saleServiceMock, times(1)).getSalesFromCaseSeller(1L,"all",0,5);
		verifyZeroInteractions(saleServiceMock);
	}
	
	@Test
	public void getSalesFromCaseSeller_DeliverySellerFound_ShouldAddSalesAndStatusAndPageQuantityToModelAndRenderSellerSalesView() throws Exception {
		Sale s1=new Sale();
		Sale s2=new Sale();
		when(saleServiceMock.getSalesFromCaseSeller(1L,"all",0,5)).thenReturn(new ArrayList<Sale>(Arrays.asList(s1,s2)));
		when(saleServiceMock.getSalesCountBySeller(1L)).thenReturn(2L);
		
		Authentication authentication = new AuthenticationDummy("ROLE_DELIVERY_SELLER");
		SecurityContext securityContext = Mockito.mock(SecurityContext.class);
		when(securityContext.getAuthentication()).thenReturn(authentication);
		SecurityContextHolder.setContext(securityContext);
		
        mockMvc.perform(get("/sellersView/seller/1/sales"))
				.andExpect(status().isOk())
				.andExpect(view().name("sellerSales"))
				.andExpect(model().attribute("status", hasSize(4)));

		 verify(saleServiceMock, times(1)).getSalesFromCaseSeller(1L,"all",0,5);
		 verify(saleServiceMock, times(1)).getSalesCountBySeller(1L);
		 verifyNoMoreInteractions(saleServiceMock);
	}
	
	@Test
	public void getSalesFromCaseSeller_StoreSellerFound_ShouldAddSalesAndStatusAndPageQuantityToModelAndRenderSellerSalesView() throws Exception {
		Sale s1=new Sale();
		Sale s2=new Sale();
		when(saleServiceMock.getSalesFromCaseSeller(1L,"all",0,5)).thenReturn(new ArrayList<Sale>(Arrays.asList(s1,s2)));
		when(saleServiceMock.getSalesCountBySeller(1L)).thenReturn(2L);
		
		Authentication authentication = new AuthenticationDummy("ROLE_STORE_SELLER");
		SecurityContext securityContext = Mockito.mock(SecurityContext.class);
		when(securityContext.getAuthentication()).thenReturn(authentication);
		SecurityContextHolder.setContext(securityContext);
		
        mockMvc.perform(get("/sellersView/seller/1/sales"))
				.andExpect(status().isOk())
				.andExpect(view().name("sellerSales"))
				.andExpect(model().attribute("status", hasSize(2)));

		 verify(saleServiceMock, times(1)).getSalesFromCaseSeller(1L,"all",0,5);
		 verify(saleServiceMock, times(1)).getSalesCountBySeller(1L);
		 verifyNoMoreInteractions(saleServiceMock);
	}
	
	/**
     * Mock class.
     */
    class AuthenticationDummy implements Authentication {

        private String role;

        AuthenticationDummy(final String role) {
            this.role = role;
        }

        /**
        * {@inheritDoc}
         * </p>
         * Override this method by just returning the authority {@link AdminRole#ROLE_ADMIN}.
        */
        @Override
        public Collection<GrantedAuthority> getAuthorities() {
            final Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>(1);
            grantedAuthorities.add(new SimpleGrantedAuthority(role));
            return grantedAuthorities;
        }

        @Override
        public Object getCredentials() {
            return null;
        }

		@Override
		public String getName() {
			return null;
		}

		@Override
		public Object getDetails() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Object getPrincipal() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean isAuthenticated() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
			// TODO Auto-generated method stub
			
		}

}

}
