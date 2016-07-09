package ilan.restcontrollers;

import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
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
import ilan.dtos.CaseDesignDTO;
import ilan.dtos.CaseDeviceDTO;
import ilan.dtos.CaseOrderDTO;
import ilan.dtos.CaseProductDTO;
import ilan.dtos.ProviderDTO;
import ilan.models.CaseDesign;
import ilan.models.CaseDevice;
import ilan.models.CaseProduct;
import ilan.models.Provider;
import ilan.services.CaseProductService;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@ContextConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class CaseProductRestControllerTest {

	@Mock
	private CaseProductService caseProductServiceMock;

	@Mock
	private Mapper mapper;
	
	@InjectMocks
	CaseProductRestController caseProductRestController;

	private MockMvc mockMvc;
	
	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));
	
	Gson gson = new Gson();
	
	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(caseProductRestController).build();
	}
	
	 @Test
	    public void getProduct_ProductFound() throws Exception {
		 Provider prov1= new Provider("name","location");
		 CaseDesign ds1 = new CaseDesign("design");
		 CaseDevice dv1 = new CaseDevice("device");
		 CaseProduct p1 = new CaseProduct(ds1, dv1, 49.99, prov1);
		 ProviderDTO prov1DTO= new ProviderDTO("name","location");
		 CaseDesignDTO ds1DTO = new CaseDesignDTO("design");
		 CaseDeviceDTO dv1DTO = new CaseDeviceDTO("device");
		 CaseProductDTO p1DTO = new CaseProductDTO(ds1DTO, dv1DTO, 49.99, prov1DTO);
	     when(caseProductServiceMock.findCaseWithDesignAndDevice("design", "device")).thenReturn(p1);
	     when(mapper.map(p1, CaseProductDTO.class)).thenReturn(p1DTO);
	     mockMvc.perform(get("/products?design=design&device=device"))
	                .andExpect(status().isOk())
	                .andExpect(content().contentType(contentType))
	                .andExpect(jsonPath("$.design.name", is(p1DTO.getDesign().getName())))
	                .andExpect(jsonPath("$.device.name", is(p1DTO.getDevice().getName())))
	                .andExpect(jsonPath("$.provider.name", is(p1DTO.getProvider().getName())))
	                .andExpect(jsonPath("$.provider.location", is(p1DTO.getProvider().getLocation())))
	                .andExpect(jsonPath("$.price", is(p1DTO.getPrice())));
	    }

}
