package ilan.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import ilan.models.CaseDesign;
import ilan.models.CaseDevice;
import ilan.services.InventoryService;
import ilan.services.ProviderService;

@Controller
@RequestMapping("/logisticView")
public class LogisticController {
	
	@Autowired
	ProviderService providerService;
	@Autowired
	InventoryService inventoryService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(value= HttpStatus.OK)
    public String logisticIndex(Model model) {
		Collection<CaseDesign> designs = inventoryService.getDesigns();
		Collection<CaseDevice> devices = inventoryService.getDevices();
		model.addAttribute("designs",designs);
    	model.addAttribute("devices",devices);
		model.addAttribute("providers",providerService.findAllProviders(0,5));
		return "logistic";
	}
}
