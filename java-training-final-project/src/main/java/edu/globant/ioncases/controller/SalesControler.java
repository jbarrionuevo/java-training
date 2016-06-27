/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.controller;

import edu.globant.ioncases.model.OrderSale;
import edu.globant.ioncases.service.CustomerService;
import edu.globant.ioncases.service.InventoryService;
import edu.globant.ioncases.service.SalesService;
import edu.globant.ioncases.service.SellerService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author federico.calarco
 */
@Controller
@RequestMapping(value = "/sales")
public class SalesControler {

    @Autowired(required = true)
    SalesService salesService;

    @Autowired(required = true)
    CustomerService customerService;

    @Autowired(required = true)
    SellerService sellerService;

    @Autowired(required = true)
    InventoryService inventoryService;

    @RequestMapping(value = "/addSale", method = RequestMethod.GET)
    public String addSale(Model model) {

        Map<Long, Integer> order = new HashMap<>();
        order.put(123L, 3);
        order.put(124L, 4);

        model.addAttribute("customers", customerService.getAll());
        model.addAttribute("sellers", sellerService.getAll());
        model.addAttribute("inventory", inventoryService.getAll());
        model.addAttribute("orderSale", order);
        return "addSale";
    }

    @RequestMapping(value = "/addSalePost", method = RequestMethod.POST)
    public String addSalePost(
            @RequestParam("customer") long idCustomer,
            @RequestParam("seller") long idSeller,
            @RequestParam(value = "orderSale", required = false) Map<Long, Integer> order,
            Model model) {

        System.out.println("---------------------> " + idCustomer + idSeller + order.size());
//
//        // TODO: SallesController -> addSale
//        OrderSale orderSale = new OrderSale();
//        orderSale.addCaseToOrder(new Case("Batman case", 20), 2);
//        orderSale.addCaseToOrder(new Case("Black case2", 4), 5);
//        
//        Store store = new Store("Store 12213");
//        
//        StoreSeller seller = new StoreSeller("Federico", store);
//
//        Customer customer = new Customer("Pepe", 21, 'M', "Madryn");
        // -------------------------------------------------------------
        //   model.addAttribute("sale", salesService.addSale2(order));
        return "sale";
    }

}