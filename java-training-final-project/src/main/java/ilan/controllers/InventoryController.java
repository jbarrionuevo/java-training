package ilan.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.persistence.criteria.CriteriaBuilder.Case;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import ilan.models.CaseDesign;
import ilan.models.CaseDevice;
import ilan.models.CaseProduct;
import ilan.models.CaseWrapper;
import ilan.models.Inventory;
import ilan.services.InventoryService;

@Controller
@RequestMapping("/inventory")
public class InventoryController {
	
	@Autowired
	InventoryService inventoryService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(value= HttpStatus.OK)
    public String getInventory(Model model) {
		Collection<CaseWrapper> wrappers = inventoryService.getInventoryWrappers(0,5);
		Collection<CaseDesign> designs = inventoryService.getDesigns();
		Collection<CaseDevice> devices = inventoryService.getDevices();
		long count = inventoryService.getInventoryCount();
		long pageQuantity = count / 5;
		if((count % 5) != 0) pageQuantity++;
		model.addAttribute("inventory",wrappers);
    	model.addAttribute("designs",designs);
    	model.addAttribute("devices",devices);
    	model.addAttribute("pageQuantity",pageQuantity);
        return "inventory";
    }
	
}
