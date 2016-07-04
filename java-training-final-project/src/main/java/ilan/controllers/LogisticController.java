package ilan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import ilan.services.InventoryService;
import ilan.services.OrderAlertService;
import ilan.services.ProviderService;

@Controller
@RequestMapping("/logisticView")
public class LogisticController {
	
	@Autowired
	ProviderService providerService;
	@Autowired
	InventoryService inventoryService;
	@Autowired
	OrderAlertService orderAlertService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(value= HttpStatus.OK)
    public String logisticIndex(Model model) {
		model.addAttribute("designs", inventoryService.getDesigns());
    	model.addAttribute("devices",inventoryService.getDevices());
		model.addAttribute("providers",providerService.findAllProviders(0,5));
		model.addAttribute("alerts",orderAlertService.findAll());
		return "logistic";
	}
}
