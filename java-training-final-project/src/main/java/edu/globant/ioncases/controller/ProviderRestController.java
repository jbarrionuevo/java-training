/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.controller;

import edu.globant.ioncases.model.Provider;
import edu.globant.ioncases.service.ProviderService;
import java.util.List;
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
public class ProviderRestController {

    @Autowired
    ProviderService providerService;
    
    
    @RequestMapping(value = "/getAllCases", method = RequestMethod.GET)
    @ResponseBody
    public List<Provider> getAllCases() {
        return providerService.getAll();

    }
}
