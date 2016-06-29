/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.service;

import edu.globant.ioncases.dao.SaleDao;
import edu.globant.ioncases.model.CaseCover;
import edu.globant.ioncases.model.Customer;
import edu.globant.ioncases.model.OrderSale;
import edu.globant.ioncases.model.OrderSale2;
import edu.globant.ioncases.model.Receipt;
import edu.globant.ioncases.model.Sale;
import edu.globant.ioncases.model.SaleStatus;
import edu.globant.ioncases.model.Seller;
import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author federico.calarco
 */
@Service
public class SalesServiceImpl implements SalesService {

    @Autowired
    SaleDao saleDao;

//    @Override
//    public Sale addSale(final Customer customer, final Seller seller, final OrderSale orderSale) {
//        // TODO: SalesService -> addSale
//        Receipt r = new Receipt(customer, new Date().toString(), calculateTotalPrice(orderSale.getOrder()), seller.getStore());
//        Sale s = new Sale(orderSale, customer, seller, SaleStatus.DRAFT, r);
//        
//        saleDao.addSale(s);
//        
//        return s;
//    }
    @Override
    public String checkSaleStatus(long saleId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private double calculateTotalPrice(Map<CaseCover, Integer> orderSale) {
        return 0;
    }

    @Override
    public Sale addSale2(OrderSale2 order) {
        Receipt r = new Receipt(order.getCustomer(), new Date().toString(), calculateTotalPrice(order.getOrder()), order.getSeller().getStore());
        Sale s = new Sale(new OrderSale(), order.getCustomer(), order.getSeller(), SaleStatus.DRAFT, r);
        saleDao.addSale(s);
        return s;
    }
}
