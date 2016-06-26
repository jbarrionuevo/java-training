/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.dao;

import edu.globant.ioncases.model.Customer;
import java.util.List;

/**
 *
 * @author fedec
 */
public interface CustomerDao {

    void add(Customer customer);

    Customer getById(long id);

    List<Customer> getAll();

}
