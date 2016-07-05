/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.controller;

import edu.globant.ioncases.dao.CaseDao;
import edu.globant.ioncases.model.CaseCover;
import edu.globant.ioncases.model.CaseInventory;
import edu.globant.ioncases.model.Cellphone;
import edu.globant.ioncases.model.Device;
import edu.globant.ioncases.model.Provider;
import edu.globant.ioncases.model.Tablet;
import edu.globant.ioncases.service.InventoryService;
import edu.globant.ioncases.service.LogisticService;
import edu.globant.ioncases.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    @Autowired
    ProviderService providerService;

    @Autowired
    LogisticService logisticService;

    @RequestMapping(value = "/showAll", method = RequestMethod.GET)
    public String show(Model model) {

        model.addAttribute("inventory", inventoryService.getAll());

        return "allInventory";
    }
    
    
    @RequestMapping(value="/addPost", method = RequestMethod.POST)
    public String addPost(@RequestParam String s){
        
        System.out.println("-----> " + s);
        
        return "index";
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

    @RequestMapping(value = "/addProvider", method = RequestMethod.GET)
    public String addProvider(Model model) {

        Provider prov1 = new Provider();
        prov1.setName("Real Case");
        
        // Provider has a List<CaseCover> casesCover
        
        Device samsungS6 = new Cellphone("Samsung S6");
        Device iphone5 = new Cellphone("Iphone 5");

        CaseCover c = new CaseCover("The Beatles case", 10);

        c.addCompatibleDevices(samsungS6);
        c.addCompatibleDevices(iphone5);
        c.addProvider(prov1);

        prov1.addCases(c);

        providerService.newProvider(prov1);

        return "index";
    }

    @RequestMapping(value = "/addOrderToProvider", method = RequestMethod.GET)
    public String addOrderToProvider(Model model) {

        // when i want make a order to provider, i have 
//        
//        Map<Long, Integer> order = new HashMap<>();
//
//        order.put(1L, 20);
//
//        logisticService.addOrderToProvider(order, 1L);

        model.addAttribute("providers", providerService.getAll());

        return "addOrderToProvider";
    }

    // describeCase
    @RequestMapping(value = "/describeCase", method = RequestMethod.GET)
    public String describeCase(@RequestParam(value = "caseId") Long caseId, Model model) {

        model.addAttribute("caseCover", caseDao.getCaseById(caseId));
        return "describeCase";
    }

}
