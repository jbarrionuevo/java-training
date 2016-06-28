package ilan.restcontrollers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    public Collection<CaseWrapper> getInventoryWithDesign(@PathVariable String design) {
		if(design.equals("all")) return inventoryService.getInventoryWrappers();
		return inventoryService.getInventoryWithDesign(design);
    }
	
	
}
