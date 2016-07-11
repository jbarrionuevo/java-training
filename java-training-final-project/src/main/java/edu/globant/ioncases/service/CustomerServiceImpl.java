/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.service;

import edu.globant.ioncases.dao.CustomerDao;
import edu.globant.ioncases.dao.GenericDao;
import edu.globant.ioncases.model.Customer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author fedec
 */
@Service
public class CustomerServiceImpl extends GenericServiceImpl<Customer, Long> implements CustomerService {

    private CustomerDao customerDao;

    public CustomerServiceImpl() {
    }

    public CustomerServiceImpl(@Qualifier("CustomerDaoImpl") GenericDao<Customer, Long> genericDao) {
        super(genericDao);
        this.customerDao = (CustomerDao) genericDao;
    }

}
