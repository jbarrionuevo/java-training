/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.service;

import edu.globant.ioncases.dao.ProviderDao;
import edu.globant.ioncases.model.Provider;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author federico.calarco
 */
@Service
public class ProviderServiceImpl implements ProviderService {
    @Autowired
    ProviderDao providerDao;

    @Override
    public List<Provider> getAll() {

        return providerDao.getAll();
    }

    @Override
    public void newProvider(Provider provider) {
        
        
        providerDao.addProvider(provider);

    }

}
