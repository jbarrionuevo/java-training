/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.dao;

import edu.globant.ioncases.model.Seller;
import edu.globant.ioncases.model.Store;
import edu.globant.ioncases.model.StoreSeller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fedec
 */
@Repository
public class SellerDaoImpl implements SellerDao {

    List<Seller> sellers = new ArrayList<>();

    public SellerDaoImpl() {
        Store s1 = new Store("Kwik-E-Mart");
        sellers.add(new StoreSeller("Apu Nahasapeemapetilon", s1));
        sellers.add(new StoreSeller("Federico Calarco", s1));
    }

    @Override
    public void add(Seller seller) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Seller> getAll() {
        return sellers;
    }

}
