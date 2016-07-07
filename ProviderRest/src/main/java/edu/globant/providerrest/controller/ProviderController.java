/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.providerrest.controller;

import edu.globant.providerrest.model.Inventory;
import edu.globant.providerrest.model.Provider;
import edu.globant.providerrest.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author federico.calarco
 */
@RestController
@RequestMapping("/provider")
public class ProviderController {

    @Autowired
    ProviderService providerService;

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    @ResponseBody
    public Provider getProvider(@RequestParam(value = "id") Long idProvider) {

        return providerService.getById(idProvider);
    }

    @RequestMapping(value = "/getInventory", method = RequestMethod.GET)
    @ResponseBody
    public Inventory getInventory(@RequestParam(value = "id") Long idProvider) {

        return providerService.getInventoryById(idProvider);
    }

}
