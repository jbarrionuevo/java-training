package ilan.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.persistence.criteria.CriteriaBuilder.Case;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import ilan.models.CaseDesign;
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
		model.addAttribute("inventory",inventoryService.getInventoryWrappers());
    	model.addAttribute("designs",inventoryService.getDesigns());
        return "cases";
    }
}
