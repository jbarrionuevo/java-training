package ilan.restcontrollers;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ilan.dtos.CaseOrderDTO;
import ilan.dtos.SaleDTO;
import ilan.models.CaseOrder;
import ilan.models.Sale;
import ilan.services.CaseOrderService;

@RestController
@RequestMapping("/orders")
public class CaseOrderRestController {
	
	@Autowired
	CaseOrderService caseOrderService;
	
	@Autowired
	private Mapper mapper;
	
	@RequestMapping(method = RequestMethod.POST, consumes="application/json;charset=UTF-8")
	@ResponseStatus(value= HttpStatus.CREATED)
	public CaseOrderDTO save(@RequestBody CaseOrderDTO caseOrderDTO){
		CaseOrder newCaseOrder = caseOrderService.save(mapper.map(caseOrderDTO,CaseOrder.class));
		CaseOrderDTO savedEntityDTO = mapper.map(newCaseOrder, CaseOrderDTO.class);
		return savedEntityDTO;
	}
}
