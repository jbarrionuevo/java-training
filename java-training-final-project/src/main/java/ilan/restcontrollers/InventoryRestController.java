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

import ilan.dtos.CaseOrderDTO;
import ilan.dtos.CaseWrapperDTO;
import ilan.models.CaseWrapper;
import ilan.services.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryRestController {
	
	@Autowired
	InventoryService inventoryService;
	
	@Autowired
	private Mapper mapper;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseStatus(value= HttpStatus.OK)
    public Collection<CaseWrapperDTO> getInventoryWithDesignAndDevice(
    							@RequestParam (value="design", required=false) String design, 
    							@RequestParam (value="device", required=false) String device,
    							@RequestParam(value = "page", required = false, defaultValue="0") Integer page,
    							@RequestParam(value = "size", required = false, defaultValue="5") Integer size) {
		return inventoryService.getInventoryWithDesignAndDevice(design,device,page,size)
				.stream()
				.map(cw->mapper.map(cw,CaseWrapperDTO.class)).collect(Collectors.toList());
    }
	
	@RequestMapping(value="/wrappers", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseStatus(value= HttpStatus.OK)
    public Collection<CaseWrapperDTO> getInventoryWrappers() {
		return inventoryService.getAllInventoryWrappers()
				.stream()
				.map(cw->mapper.map(cw,CaseWrapperDTO.class)).collect(Collectors.toList());
    }
	
	@RequestMapping(value="/count", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseStatus(value= HttpStatus.OK)
    public Long getInventoryCountWithDesignAndDevice(
			    		@RequestParam (value="design", required=true) String design, 
						@RequestParam (value="device", required=true) String device) {
		return inventoryService.getCount(design, device);
    }
	
	
	@RequestMapping(value="/supply/{orderId}", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
	@ResponseStatus(value= HttpStatus.OK)
	public void supplyStock(@PathVariable Long orderId){
		inventoryService.supplyStock(orderId);
	}
	
	@RequestMapping(value="/caseWrappers/{caseWrapperId}/minimumStock", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
	@ResponseStatus(value= HttpStatus.OK)
	public void updateCaseWrapperMinimumStock(@PathVariable Long caseWrapperId, @RequestBody Integer newStock){
		inventoryService.updateCaseWrapper(caseWrapperId,newStock);
	}
}
