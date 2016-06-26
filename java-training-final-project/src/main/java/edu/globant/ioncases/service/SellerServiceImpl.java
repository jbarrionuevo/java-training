/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.service;

import edu.globant.ioncases.dao.SellerDao;
import edu.globant.ioncases.model.Seller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fedec
 */
@Service
public class SellerServiceImpl implements SellerService{
    
    @Autowired
    SellerDao sellerDao;

    @Override
    public void add(Seller seller) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Seller> getAll() {
        return sellerDao.getAll();
    }
    
}
