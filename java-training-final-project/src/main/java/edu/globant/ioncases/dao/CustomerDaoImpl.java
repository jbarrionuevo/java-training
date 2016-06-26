/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.dao;

import edu.globant.ioncases.model.Customer;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fedec
 */
@Repository
public class CustomerDaoImpl implements CustomerDao{
    
    List<Customer> customers = new ArrayList<>();
    
    public CustomerDaoImpl() {
        customers.add(new Customer("Homer Simpson", 38, 'M', "Sprinfield"));
        customers.add(new Customer("Marge Simpson", 34, 'F', "Sprinfield"));
        customers.add(new Customer("Bart Simpson", 10, 'M', "Sprinfield"));
        customers.add(new Customer("Lisa Simpson", 8, 'F', "Sprinfield"));
    }
    

    @Override
    public void add(Customer customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer getById(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Customer> getAll() {
        return customers;
    }
    
}
