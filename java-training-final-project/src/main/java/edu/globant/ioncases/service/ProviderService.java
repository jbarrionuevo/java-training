/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.service;

import edu.globant.ioncases.model.Provider;
import java.util.List;

/**
 *
 * @author federico.calarco
 */
public interface ProviderService {
    
    List<Provider> getAll();
    
    void newProvider(Provider provider);
    
    Provider getProviderById(Long id);

    
    
    
}
