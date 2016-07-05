package ilan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import ilan.services.ProviderService;

@Controller
@RequestMapping("/providersView")
public class ProviderController {

	@Autowired
	ProviderService providerService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(value= HttpStatus.OK)
    public String getProviders(Model model) {
		model.addAttribute("providers",providerService.findAllProviders());
		return "providers";
	}
}
