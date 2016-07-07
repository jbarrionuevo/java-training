/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.providerrest.dao;

import edu.globant.providerrest.model.CaseProduct;
import edu.globant.providerrest.model.Device;
import edu.globant.providerrest.model.Inventory;
import edu.globant.providerrest.model.Provider;
import edu.globant.providerrest.model.TypeDevice;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author federico.calarco
 */
@Repository
@Transactional
public class ProviderDaoImpl implements ProviderDao {

    List<Provider> providers = new ArrayList<>();

    public ProviderDaoImpl() {
        
        providers.add(new Provider());

        Device iPhone6 = new Device(1L, TypeDevice.CELLPHONE, "Iphone 6");
        Device iPhone6S = new Device(2L, TypeDevice.CELLPHONE, "Iphone 6S");
        Device samsungS6 = new Device(3L, TypeDevice.CELLPHONE, "Samsung Galaxy S6");
        Device iPadAir2 = new Device(4L, TypeDevice.TABLET, "iPad Air 2");
        Device iPadAir = new Device(5L, TypeDevice.TABLET, "iPad Air");

        Inventory inventoryRC = new Inventory();

        inventoryRC.setId(1L);

        List<CaseProduct> inventory1 = new ArrayList<>();

        CaseProduct case1 = new CaseProduct(1L, "Iphone 6 Leather Case - Marine Blue", 20);
        CaseProduct case2 = new CaseProduct(2L, "Samsung S6 - Red", 15);

        List<Device> compatibleDevices = new ArrayList<>();

        compatibleDevices.add(iPhone6);
        compatibleDevices.add(iPhone6S);

        List<Device> compatibleDevices2 = new ArrayList<>();

        compatibleDevices2.add(samsungS6);

        case1.setCompatibleDevices(compatibleDevices);
        case2.setCompatibleDevices(compatibleDevices2);

        inventory1.add(case1);
        inventory1.add(case2);

        inventoryRC.setInventory(inventory1);

        Provider realCase = new Provider(1L, "REAL CASE", inventoryRC);

        providers.add(realCase);

    }

    @Override
    public List<Provider> getAll() {
        return providers;
    }

    @Override
    public Provider getById(Long id) {
        System.out.println(" +++++++++++++++++++++++++++++ "+id);
        return providers.get(id.intValue());
    }

    @Override
    public Inventory getInventoryById(Long id) {

        Provider p = providers.get(id.intValue());
        return p.getInventory();
    }

}
