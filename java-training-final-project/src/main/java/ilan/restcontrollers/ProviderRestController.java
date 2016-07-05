package ilan.restcontrollers;

import java.util.Iterator;
import java.util.Map;

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

	@RequestMapping(value = "/{providerId}/order", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void createOrder(@PathVariable Long providerId, 
							@RequestBody CaseOrderDTO caseOrderDTO, 
							@RequestParam (value="orderAlertId", required=false, defaultValue="0") Long orderAlertId) {
		providerService.addOrder(providerId, mapper.map(caseOrderDTO, CaseOrder.class), orderAlertId);
	}
}
