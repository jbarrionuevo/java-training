package ilan.restcontrollers;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ilan.dtos.CaseOrderDTO;
import ilan.models.CaseOrder;
import ilan.services.ProviderService;

@RestController
@RequestMapping("/providers")
public class ProviderRestController {
	@Autowired
	ProviderService providerService;

	@Autowired
	private Mapper mapper;

	@RequestMapping(value = "/{providerId}/orders", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void createOrder(@PathVariable Long providerId, 
							@RequestBody CaseOrderDTO caseOrderDTO, 
							@RequestParam (value="orderAlertId", required=false, defaultValue="0") Long orderAlertId) {
		providerService.addOrder(providerId, mapper.map(caseOrderDTO, CaseOrder.class), orderAlertId);
	}
	
	@RequestMapping(value = "/{providerId}/orders", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public Collection<CaseOrderDTO> getOrders(@PathVariable Long providerId, @RequestParam (value="delivered", required=false, defaultValue="all") String delivered) {
		return providerService.getProviderOrders(providerId,delivered).stream().map(o->mapper.map(o,CaseOrderDTO.class)).collect(Collectors.toList());
	}
}
