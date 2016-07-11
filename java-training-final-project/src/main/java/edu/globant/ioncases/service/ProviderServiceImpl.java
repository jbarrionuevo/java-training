/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.service;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import edu.globant.ioncases.dao.GenericDao;
import edu.globant.ioncases.dao.ProviderDao;
import edu.globant.ioncases.model.CaseProduct;
import edu.globant.ioncases.model.Cellphone;
import edu.globant.ioncases.model.Device;
import edu.globant.ioncases.model.Provider;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author federico.calarco
 */
@Service
public class ProviderServiceImpl extends GenericServiceImpl<Provider, Long> implements ProviderService {

    private ProviderDao providerDao;

    public ProviderServiceImpl() {
    }

    @Autowired
    public ProviderServiceImpl(@Qualifier("ProviderDaoImpl") GenericDao<Provider, Long> genericDao) {
        super(genericDao);
        this.providerDao = (ProviderDao) genericDao;
    }

    @Override
    public void add(String name, String urlServiceInventory) {

        List<CaseProduct> inventory = new ArrayList<>();

        CaseProduct caseProduct;

        List<Device> compatibleDevices;

        try {
            String resultFromGetToBaseUrl = Unirest.get(urlServiceInventory)
                    .asString().getBody();

            JSONObject myjson = new JSONObject(resultFromGetToBaseUrl);

            JSONArray the_json_array = myjson.getJSONArray("inventory");

            for (int i = 0; i < the_json_array.length(); i++) {
                System.out.println("---------> " + the_json_array.getJSONObject(i).get("design"));

                caseProduct = new CaseProduct();

                caseProduct.setDesign(the_json_array.getJSONObject(i).get("design").toString());

                caseProduct.setPrice(Double.parseDouble(the_json_array.getJSONObject(i).get("price").toString()));

                JSONArray the_json_array2 = the_json_array.getJSONObject(i).getJSONArray("compatibleDevices");

                compatibleDevices = new ArrayList<>();

                for (int j = 0; j < the_json_array2.length(); j++) {
                    System.out.println("111 -> " + the_json_array2.getJSONObject(j).get("model"));

                    compatibleDevices.add(new Cellphone(the_json_array2.getJSONObject(j).get("model").toString()));
                }
                caseProduct.setCompatibleDevices(compatibleDevices);
                inventory.add(caseProduct);

            }

        } catch (UnirestException ex) {
            //Logger.getLogger(ProviderServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Err: " + ex);
        }

        Provider p = new Provider();

        p.setName(name);
        p.setCases(inventory);

        providerDao.saveOrUpdate(p);

        //  p.setCases(cases);
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
