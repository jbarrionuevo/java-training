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
import ilan.models.CaseDesign;
import ilan.models.CaseDevice;
import ilan.models.CaseWrapper;
import ilan.services.InventoryService;

@RestController
@RequestMapping("/inventoryrest")
public class InventoryRestController {
	
	@Autowired
	InventoryService inventoryService;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseStatus(value= HttpStatus.OK)
    public Collection<CaseWrapper> getInventoryWithDesignAndDevice(
    							@RequestParam (value="design", required=false) String design, 
    							@RequestParam (value="device", required=false) String device,
    							@RequestParam(value = "page", required = false, defaultValue="0") Integer page,
    							@RequestParam(value = "size", required = false, defaultValue="5") Integer size) {
		return inventoryService.getInventoryWithDesignAndDevice(design,device,page,size);
    }
	
	@RequestMapping(value="/count", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseStatus(value= HttpStatus.OK)
    public Long getInventoryCountWithDesignAndDevice(
			    		@RequestParam (value="design", required=true) String design, 
						@RequestParam (value="device", required=true) String device) {
		Long result = inventoryService.getCount(design, device);
		return result;
    }
	
	
}
