/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.controller;

import edu.globant.ioncases.dao.CaseDao;
import edu.globant.ioncases.dao.CaseDaoImpl;
import edu.globant.ioncases.model.CaseCover;
import edu.globant.ioncases.model.CaseInventory;
import edu.globant.ioncases.model.Cellphone;
import edu.globant.ioncases.model.Device;
import edu.globant.ioncases.model.Provider;
import edu.globant.ioncases.model.Tablet;
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

    @Autowired
    CaseDao caseDao;

    @RequestMapping(value = "/showAll", method = RequestMethod.GET)
    public String show(Model model) {

        model.addAttribute("inventory", inventoryService.getAll());

        return "allInventory";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {

        Device tablet = new Tablet("Ipad 5");
        Device celu = new Cellphone("Iphone 5");
        
        CaseCover c = new CaseCover("testDesiign", 13);
        
        c.addCompatibleDevices(tablet);
        c.addCompatibleDevices(celu);
        
        Provider prov = new Provider();
        prov.setName("Provedor cases apple");
        
        c.addProvider(prov);
        caseDao.addCase(c);

        CaseCover c2 = caseDao.getCaseById(1);
        System.out.println("9999999999999> " + c2.getDesign() + " - " + c2.getPrice());
        
        inventoryService.addCase(c2, 22);
        

        
        
        
        return "addCaseToInventory";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute(value = "CaseInventory") CaseInventory caseInventory) {

        return "index";
    }

}
