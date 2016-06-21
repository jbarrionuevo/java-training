/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.day1.exercises.layersAndTier.IONSolidAplication.Dao;


import edu.globant.day1.exercises.layersAndTier.IONSolidAplication.Entity.Customer;
import java.util.List;

/**
 *
 * @author fedec
 */
public interface CustomerDao {

    void create(Customer customer);

    Customer read(Customer customer);

    Customer readById(int id);

    List<Customer> getAll();

    void update(Customer customer);

    void delete(Customer customer);

}
