package ilan.restcontrollers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ilan.daos.InventoryDao;
import ilan.models.CaseWrapper;
import ilan.services.InventoryService;

@RestController
@RequestMapping("/inventoryrest")
public class InventoryRestController {
	
	@Autowired
	InventoryService inventoryService;
	
	@RequestMapping(value="/design/{design}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseStatus(value= HttpStatus.OK)
    public Collection<CaseWrapper> getInventoryWithDesign(
    					@PathVariable String design,
    					@RequestParam(value = "page", required = false, defaultValue="0") Integer page,
    					@RequestParam(value = "size", required = false, defaultValue="5") Integer size) {
		if(design.equals("all")) return inventoryService.getInventoryWrappers(page,size);
		return inventoryService.getInventoryWithDesign(design,page,size);
    }
	
	@RequestMapping(value="/device/{device}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseStatus(value= HttpStatus.OK)
    public Collection<CaseWrapper> getInventoryWithDevice(
			    		@PathVariable String device,
			    		@RequestParam(value = "page", required = false, defaultValue="0") Integer page,
						@RequestParam(value = "size", required = false, defaultValue="5") Integer size) {
		if(device.equals("all")) return inventoryService.getInventoryWrappers(page,size);
		return inventoryService.getInventoryWithDevice(device,page,size);
    }
	
	@RequestMapping(value="/design/{design}/device/{device}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseStatus(value= HttpStatus.OK)
    public Collection<CaseWrapper> getInventoryWithDesignAndDevice(
    							@PathVariable String design, @PathVariable String device,
    							@RequestParam(value = "page", required = false, defaultValue="0") Integer page,
    							@RequestParam(value = "size", required = false, defaultValue="5") Integer size) {
		return inventoryService.getInventoryWithDesignAndDevice(design,device,page,size);
    }
	
	
}
