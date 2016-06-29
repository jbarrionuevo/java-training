package edu.globant.finalProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.globant.finalProject.service.InventoryService;

@Controller
@RequestMapping("/inventory")
public class InventoryController {
	
	@Autowired(required = true)
    InventoryService inventoryService;
	
	@RequestMapping(value = "/showTotalInventory")
    public String showTotalInventory(Model model) {
		model.addAttribute("inventory",inventoryService.getAll());
        return "Inventory";
    }

}
