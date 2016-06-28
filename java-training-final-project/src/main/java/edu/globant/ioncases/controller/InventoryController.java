/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.controller;

import edu.globant.ioncases.model.Case;
import edu.globant.ioncases.model.CaseInventory;
import edu.globant.ioncases.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author federico.calarco
 */
@Controller
@RequestMapping(value = "/inventory")
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @RequestMapping(value = "/showAll", method = RequestMethod.GET)
    public String show(Model model) {

        model.addAttribute("inventory", inventoryService.getAll());

        return "allInventory";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        
        inventoryService.addCase(new Case("desiggnnn", 20000), 99);
        return "addCaseToInventory";
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute(value = "CaseInventory") CaseInventory caseInventory){
        
        return "index";
    }
    

}
