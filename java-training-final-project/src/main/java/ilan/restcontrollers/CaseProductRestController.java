package ilan.restcontrollers;

import java.util.Collection;
import java.util.stream.Collectors;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ilan.dtos.CaseOrderDTO;
import ilan.dtos.CaseProductDTO;
import ilan.services.CaseProductService;

@RestController
@RequestMapping("/products")
public class CaseProductRestController {
	@Autowired
	CaseProductService caseProductService;

	@Autowired
	private Mapper mapper;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public CaseProductDTO getProduct(
			@RequestParam (value="design", required=true) String design,
			@RequestParam (value="device", required=true) String device) {
		return mapper.map(caseProductService.findCaseWithDesignAndDevice(design,device),CaseProductDTO.class);
	}
}
