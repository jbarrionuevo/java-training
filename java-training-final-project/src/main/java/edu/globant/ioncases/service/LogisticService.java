/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.service;

import edu.globant.ioncases.model.CaseCover;
import edu.globant.ioncases.model.Provider;
import java.util.Map;

/**
 *
 * @author federico.calarco
 */
public interface LogisticService {
    
    void addOrderToProvider(Map<CaseCover,Integer> order, Provider provider);
}
