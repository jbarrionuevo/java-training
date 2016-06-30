/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.dao;

import edu.globant.ioncases.model.Provider;
import java.util.List;

/**
 *
 * @author federico.calarco
 */
public interface ProviderDao {
    
    Provider getById(Long id);
    void addProvider(Provider provider);
    List<Provider> getAll ();
    
    
}
