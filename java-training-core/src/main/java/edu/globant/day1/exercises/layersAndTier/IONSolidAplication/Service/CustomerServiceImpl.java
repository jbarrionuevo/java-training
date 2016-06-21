/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.day1.exercises.layersAndTier.IONSolidAplication.Service;

import edu.globant.day1.exercises.layersAndTier.IONSolidAplication.Dao.CustomerDao;
import edu.globant.day1.exercises.layersAndTier.IONSolidAplication.Dao.CustomerDaoImpl;
import edu.globant.day1.exercises.layersAndTier.IONSolidAplication.Entity.Customer;


/**
 *
 * @author fedec
 */
 public class CustomerServiceImpl implements CustomerService{

     private CustomerDao customerDao = new CustomerDaoImpl();
     

    @Override
    public void newCustomer(Customer customer) {
        customerDao.create(customer);
    }

    @Override
    public Customer getCustomerById(int id) {
        return customerDao.readById(id);
    }
    
}
