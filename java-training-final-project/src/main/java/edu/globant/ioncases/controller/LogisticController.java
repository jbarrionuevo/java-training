/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.controller;

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

    @RequestMapping(value = "/addProvider", method = RequestMethod.GET)
    public String addProvider() {

        return "addProvider";
    }

    @RequestMapping(value = "/addProvider", method = RequestMethod.POST)
    public String addProvider(@RequestParam(value = "name") String name, @RequestParam(value = "inventoryUrl") String inventoryUrl) {

        System.out.println("-----------> " + name + "----> " + inventoryUrl);
        
        // 1) Send name & inventoryUrl to providerService.add(name,iventory)
        // 2) 
        
        
        return "index";
    }

}
