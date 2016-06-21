/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.service;

import edu.globant.ioncases.entity.Customer;

/**
 *
 * @author fedec
 */
public interface CustomerService {
    
    void newCustomer(Customer customer);
    Customer getCustomerById(int id);
            
            
            
}
