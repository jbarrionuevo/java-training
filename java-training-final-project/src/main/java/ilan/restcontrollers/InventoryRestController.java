package ilan.restcontrollers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ilan.models.CaseWrapper;
import ilan.services.InventoryService;
import net.minidev.json.parser.ParseException;

@RestController
@RequestMapping("/inventory")
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
	
	@RequestMapping(value="/buy/{products}", method = RequestMethod.GET, produces = "text/plain")
	@ResponseStatus(value= HttpStatus.OK)
    public String buyProduct(@PathVariable String products) throws ParseException {
		JSONObject  object = new JSONObject(products);
		Iterator<?> keys = object.keys(); //each one is a CaseWrapper
		Map<Long,Integer> desire = new HashMap<Long,Integer>();
		while( keys.hasNext() ) {
		    String key = (String)keys.next();
		    desire.put(Long.parseLong(key), Integer.parseInt((String) ((JSONObject)object.get(key)).get("quantity")));
		}
		return inventoryService.buyProducts(desire);
    }
	
	
}
