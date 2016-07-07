/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.controller;

import edu.globant.ioncases.model.CaseCover;
import edu.globant.ioncases.model.Provider;
import edu.globant.ioncases.service.ProviderService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.globant.ioncases.service.LogisticService;
import java.io.IOException;

/**
 *
 * @author federico.calarco
 */
@RestController
@RequestMapping("/provider")
public class ProviderRestController {

    @Autowired
    ProviderService providerService;

    @Autowired
    LogisticService logisticService;

    
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    @ResponseBody
    public Provider getProvider(@RequestParam(value = "id") Long idProvider) {

        return providerService.getProviderById(idProvider);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public List<Provider> getAllProviders() {
        return providerService.getAll();
    }

    @RequestMapping(value = "/getAllCasesByProvider", method = RequestMethod.GET)
    @ResponseBody
    public List<CaseCover> getAllCases(@RequestParam(value = "id") Long idProvider) {

        Provider provider = providerService.getProviderById(idProvider);

        List<CaseCover> caseCover = provider.getCases();

        return provider.getCases();

    }

    @RequestMapping(value = "/addPost", method = RequestMethod.POST)
    @ResponseBody
    public String addPost(@RequestParam(value = "data") String orderStr) throws IOException {

        System.out.println(orderStr);

        Map<Long, Integer> order = jsonToMap(orderStr);

        System.out.println(order);

        logisticService.addOrderToProvider(order);

        return "Order sended to providers";
    }

    public static Map<Long, Integer> jsonToMap(String json) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        Map<Long, Integer> map;

        map = mapper.readValue(json, new TypeReference<Map<Long, Integer>>() {
        });

        return map;
    }
}
