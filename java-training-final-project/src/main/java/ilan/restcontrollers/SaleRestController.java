package ilan.restcontrollers;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ilan.dtos.SaleDTO;
import ilan.models.Sale;
import ilan.services.SaleService;

@RestController
@RequestMapping("/sales")
public class SaleRestController {
	
	@Autowired
	SaleService saleService;
	
	@Autowired
	private Mapper mapper;
	
	@RequestMapping(method = RequestMethod.POST, consumes="application/json;charset=UTF-8")
	@ResponseStatus(value= HttpStatus.CREATED)
	public SaleDTO save(@RequestBody SaleDTO saleDTO){
		Sale newSale=saleService.save(mapper.map(saleDTO,Sale.class));
		SaleDTO savedEntityDTO = mapper.map(newSale, SaleDTO.class);
		return savedEntityDTO;
	}
}
