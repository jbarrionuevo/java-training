/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.service;

import edu.globant.ioncases.dao.GenericDao;
import edu.globant.ioncases.dao.ProviderDao;
import edu.globant.ioncases.model.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author federico.calarco
 */
@Service
public class ProviderServiceImpl extends GenericServiceImpl<Provider, Long> implements ProviderService {

    private ProviderDao providerDao;
    
    public ProviderServiceImpl(){}
    
    @Autowired
    public ProviderServiceImpl(@Qualifier("ProviderDaoImpl") GenericDao<Provider,Long> genericDao){
        super(genericDao);
        this.providerDao = (ProviderDao) genericDao;
    }
    
    






//
//    @Autowired
//    ProviderDao providerDao;

    
    
    
//    @Override
//    public List<Provider> getAll() {
//
//        return providerDao.getAll();
//    }
//
//    @Override
//    public void newProvider(Provider provider) {
//
//        Provider OMCase = new Provider();
//        OMCase.setName("OMCase");
//
//        Device iPad = new Tablet("iPad");
//        Device surface = new Tablet("Surface");
//        Device iPad2 = new Tablet("iPad2");
//
//        CaseCover c = new CaseCover("The Batman case", 15);
//
//        c.addCompatibleDevices(iPad);
//        c.addCompatibleDevices(surface);
//        c.addProvider(OMCase);
//
//        CaseCover d = new CaseCover("The robin case", 5);
//        d.addCompatibleDevices(iPad2);
//   //     d.addProvider(OMCase);
//
//        OMCase.addCases(c);
//        OMCase.addCases(d);
//
//        providerDao.add(OMCase);
//        providerDao.add(provider);
//
//    }
//
//    @Override
//    public Provider getProviderById(Long id) {
//        return providerDao.find(id);
//    }



}
