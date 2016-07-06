/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.service;

import edu.globant.ioncases.dao.CaseDao;
import edu.globant.ioncases.dao.ProviderDao;
import edu.globant.ioncases.model.Provider;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author federico.calarco
 */
@Service
public class LogisticServiceImpl implements LogisticService {

    @Autowired
    ProviderDao providerDao;

    @Autowired
    InventoryService invetoryService;

    @Autowired
    CaseDao caseDao;

    @Override
    public void addOrderToProvider(Map<Long, Integer> order) {

   //     Provider provider = providerDao.getById(idProvider);
   
   // If the case exist -> update quantity stock
   // else -> create new caseInventory

        order.forEach((k, v) -> invetoryService.addCase(caseDao.getCaseById(k), v));
    }

}
