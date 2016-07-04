package ilan.restcontrollers;

import java.util.Collection;
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
	
	@RequestMapping(value="/{saleId}",method = RequestMethod.GET)
	@ResponseStatus(value= HttpStatus.OK)
	public SaleDTO getSale(@PathVariable Long saleId){
		return mapper.map(saleService.getSale(saleId),SaleDTO.class);
	}
	
	@RequestMapping(value="/{saleId}",method = RequestMethod.PUT)
	@ResponseStatus(value= HttpStatus.CREATED)
	public void updateStatus(@PathVariable Long saleId, @RequestParam (value="status", required=true) String status){
		saleService.update(saleId, status);
	}
	
	@RequestMapping(value="/seller/{sellerId}",method = RequestMethod.GET)
	@ResponseStatus(value= HttpStatus.OK)
	public Collection<SaleDTO> getSalesFromCaseSeller(@PathVariable Long sellerId,
			@RequestParam (value="status", required=false) String status,
			@RequestParam(value = "page", required = false, defaultValue="0") Integer page,
			@RequestParam(value = "size", required = false, defaultValue="5") Integer size){
		Collection<SaleDTO> sales = saleService.getSalesFromCaseSeller(sellerId,status,page,size).stream().map(s->mapper.map(s, SaleDTO.class)).collect(Collectors.toList());
		return sales;
	}
	
	@RequestMapping(value="/seller/{sellerId}/count", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseStatus(value= HttpStatus.OK)
    public Long getSalesCountWithStatus(
    					@PathVariable Long sellerId,
			    		@RequestParam (value="status", required=true) String status) {
		long result = saleService.getCount(sellerId, status);
		return result;
    }
}
