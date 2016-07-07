/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.providerrest.service;

import edu.globant.providerrest.dao.ProviderDao;
import edu.globant.providerrest.model.Inventory;
import edu.globant.providerrest.model.Provider;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author federico.calarco
 */
@Service
public class ProviderServiceImpl implements ProviderService{

    @Autowired
    ProviderDao providerDao;
    
    @Override
    public List<Provider> getAll() {
        return providerDao.getAll();
    }

    @Override
    public Provider getById(Long id) {
        return providerDao.getById(id);
    }

    @Override
    public Inventory getInventoryById(Long id) {
        return providerDao.getInventoryById(id);
    }


    
}
