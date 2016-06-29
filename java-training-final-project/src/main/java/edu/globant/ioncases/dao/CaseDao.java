/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.dao;

import edu.globant.ioncases.model.CaseCover;
import java.util.List;

/**
 *
 * @author federico.calarco
 */
public interface CaseDao {
    
    void addCase(CaseCover caseCover);
    CaseCover getCaseById(long id);
    List<CaseCover> getAllCase();
    
}
