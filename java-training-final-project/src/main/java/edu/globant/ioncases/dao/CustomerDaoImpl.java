/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.dao;

import edu.globant.ioncases.entity.Customer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fedec
 */
public class CustomerDaoImpl implements CustomerDao{

    //test
    private List<Customer> customers = new ArrayList<Customer>();
    
    
    @Override
    public void create(Customer customer) {
        customers.add(customer);
        System.out.println("Customer created OK: " + customer.getName());
    }

    @Override
    public Customer read(Customer customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer readById(int id) {
        return customers.get(id);
    }

    @Override
    public List<Customer> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Customer customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Customer customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
