package edu.globant.finalproject.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.globant.finalproject.Service.CaseStockService;
import edu.globant.finalproject.Service.InventoryService;
import edu.globant.finalproject.Service.InventoryServiceImpl;
import edu.globant.finalproject.Service.ProviderService;
import edu.globant.finalproject.dao.CaseDAO;
import edu.globant.finalproject.hibernate.CaseCoverage;
import edu.globant.finalproject.hibernate.Order;
import edu.globant.finalproject.hibernate.Provider;
import edu.globant.finalproject.model.Provider.OrderDTO;
import edu.globant.finalproject.model.Provider.ProviderDTO;

@Controller
@RequestMapping(value = "/logistic")
public class LogisticController {
	
	@Autowired(required = true)
    private InventoryService inventoryService;
	
	@Autowired(required = true)
    private CaseStockService caseStockService;
	
	@Autowired(required = true)
    private ProviderService providerService;
	
	@Autowired
	private MessageSource messageSource;
	
	public LogisticController() {}
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "login";
    }

    @RequestMapping(value = "/allInventory", method = RequestMethod.GET)
    public String allInventory(Model model) {
        model.addAttribute("allInventory", caseStockService.getAll());
        return "allInventory";
    }
    
    
    @RequestMapping(value = "/addProvider", method = RequestMethod.POST)
    public String addProvider(
    		@ModelAttribute("provider") Provider provider,
    		HttpServletRequest httpServletRequest,
    		Locale locale, 
    		RedirectAttributes redirectAttributes) {
    	
    	List<Order> orders = new ArrayList<Order>();
    	provider.setOrders(orders);
    	
    	providerService.add(provider);
    	
    	redirectAttributes.addFlashAttribute("SUCCESS_MESSAGE", provider.getName() + " was successfully created!");
        return "redirect:/logistic/addProvider";
    }

	@RequestMapping(value = "/addProvider", method = RequestMethod.GET)
    public String addProvider(Model model) {
        return "addProvider";
    }

//    @RequestMapping(value = "/addCase", method = RequestMethod.GET)
//    public String addCase(Model model) {
//        model.addAttribute("addCase", inventoryService.add(model));
//    	
//    	
//        return "addCase";
//    }
    
//    @RequestMapping(value = "/addOrderToProvider", method = RequestMethod.GET)
//    public String addOrderToProvider(Model model) {
//        model.addAttribute("providers", providerService.);
//    	
//    	
//        return "addOrderToProvider";
//    }
    

//
//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public String add(@ModelAttribute(value = "CaseInventory") CaseInventory caseInventory) {
//
//        return "index";
//    }
//

}
