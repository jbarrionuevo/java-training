/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.controller;

import edu.globant.ioncases.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author federico.calarco
 */
@Controller
@RequestMapping(value = "/logistic")
public class LogisticController {
    
    @Autowired
    ProviderService providerService;
    
    @RequestMapping(value = "/addProvider", method = RequestMethod.GET)
    public String addProvider() {
        
        return "addProvider";
    }
    
    @RequestMapping(value = "/addProvider", method = RequestMethod.POST)
    public String addProvider(@RequestParam(value = "name") String name, @RequestParam(value = "inventoryUrl") String inventoryUrl) {
        
        System.out.println("-----------> " + name + "----> " + inventoryUrl);

        providerService.add(name, inventoryUrl);
        
        return "index";
    }
    
}
