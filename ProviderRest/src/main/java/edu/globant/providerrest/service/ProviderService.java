/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.providerrest.service;

import edu.globant.providerrest.model.Inventory;
import edu.globant.providerrest.model.Provider;
import java.util.List;

/**
 *
 * @author federico.calarco
 */
public interface ProviderService {
    
    List<Provider> getAll();
    Provider getById(Long id);
    Inventory getInventoryById(Long id);
    
}
