package edu.globant.finalproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.globant.finalproject.Service.InventoryService;
import edu.globant.finalproject.Service.InventoryServiceImpl;
import edu.globant.finalproject.dao.CaseDAO;
import edu.globant.finalproject.hibernate.Case;

@Controller
@RequestMapping(value = "/logistic")
public class LogisticController {
	
	@Autowired
    InventoryService inventoryService;

    @Autowired
    CaseDAO caseDAO;

//    @Autowired
//    ProviderService providerService;
//
//    @Autowired
//    LogisticService logisticService;
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

    @RequestMapping(value = "/allInventory", method = RequestMethod.GET)
    public String allInventory(Model model) {
        model.addAttribute("allInventory", inventoryService.getAll());
        return "allInventory";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        //model.addAttribute("allInventory", inventoryService.getAll());
    	
    	Case c = new Case()
        return "allInventory";
    }
//    @RequestMapping(value = "/add", method = RequestMethod.GET)
//    public String add(Model model) {
//
//        Device tablet = new Tablet("Ipad 5");
//        Device celu = new Cellphone("Iphone 5");
//
//        CaseCover c = new CaseCover("testDesiign", 13);
//
//        c.addCompatibleDevices(tablet);
//        c.addCompatibleDevices(celu);
//
//        Provider prov = new Provider();
//        prov.setName("Provedor cases apple");
//
//        c.addProvider(prov);
//        caseDao.addCase(c);
//
//        CaseCover c2 = caseDao.getCaseById(1);
//        System.out.println("9999999999999> " + c2.getDesign() + " - " + c2.getPrice());
//
//        inventoryService.addCase(c2, 22);
//
//        return "addCaseToInventory";
//    }
//
//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public String add(@ModelAttribute(value = "CaseInventory") CaseInventory caseInventory) {
//
//        return "index";
//    }
//
//    @RequestMapping(value = "/addProvider", method = RequestMethod.GET)
//    public String addProvider(Model model) {
//
//        Provider prov1 = new Provider();
//        prov1.setName("Provider 1");
//
//        Device tablet = new Tablet("Ipad 5");
//        Device celu = new Cellphone("Iphone 5");
//
//        CaseCover c = new CaseCover("testDesiign", 13);
//
//        c.addCompatibleDevices(tablet);
//        c.addCompatibleDevices(celu);
//        c.addProvider(prov1);
//
//        prov1.addCases(c);
//
//        providerService.newProvider(prov1);
//
//        return "index";
//    }
//
//    @RequestMapping(value = "/addOrderToProvider", method = RequestMethod.GET)
//    public String addOrderToProvider(Model model) {
//
//        Map<Long, Integer> order = new HashMap<>();
//
//        order.put(1L, 20);
//
//        logisticService.addOrderToProvider(order, 1L);
//
//        return "index";
//    }
//
//    // describeCase
//    @RequestMapping(value = "/describeCase", method = RequestMethod.GET)
//    public String describeCase(@RequestParam(value = "caseId") Long caseId, Model model) {
//
//        model.addAttribute("caseCover", caseDao.getCaseById(caseId));
//        return "describeCase";
//    }
}
