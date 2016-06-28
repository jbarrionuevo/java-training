/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fedec
 */
@RestController
@RequestMapping("/salesRest")
public class SalesControllerRest {

    @RequestMapping(value = "/addSale", method = RequestMethod.GET)
    public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return name;
    }
}
