/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.dao;

import edu.globant.ioncases.model.Sale;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author federico.calarco
 */
@Repository
public class SaleDaoImpl implements SaleDao{
    
    List<Sale> sales = new ArrayList<>();

    
    @Override
    public void addSale(Sale sale) {
        sales.add(sale);
    }

    @Override
    public List<Sale> getAllSales() {
        return sales;
    }
    
}
