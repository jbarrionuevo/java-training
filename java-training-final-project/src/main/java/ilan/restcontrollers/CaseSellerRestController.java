package ilan.restcontrollers;

import java.util.ArrayList;
import java.util.Collection;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ilan.dtos.SaleDTO;
import ilan.models.CaseOrder;
import ilan.models.Receipt;
import ilan.models.Sale;
import ilan.services.CaseSellerService;

@RestController
@RequestMapping("/caseSellers")
public class CaseSellerRestController {

	@Autowired
	CaseSellerService caseSellerService;
	
	@Autowired
	private Mapper mapper;
	
	@RequestMapping(value="/{caseSellerId}/addSale",method = RequestMethod.PUT)
	@ResponseStatus(value= HttpStatus.OK)
	public void addSale(@PathVariable Long caseSellerId, @RequestBody SaleDTO saleDTO){
//		Collection<Receipt> receipts = new ArrayList<Receipt>(){{add(mapper.map(saleDTO.getReceipts().iterator().next(), Receipt.class));}};
		CaseOrder order = mapper.map(saleDTO.getCaseOrder(), CaseOrder.class);
		caseSellerService.addSale(caseSellerId, new Sale(order));
	}

	
}
