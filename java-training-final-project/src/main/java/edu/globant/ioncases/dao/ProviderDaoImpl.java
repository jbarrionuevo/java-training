/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.dao;

import edu.globant.ioncases.model.Provider;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author federico.calarco
 */
@Repository("ProviderDaoImpl")
@Transactional
public class ProviderDaoImpl extends GenericDaoImpl<Provider, Long> implements ProviderDao {

}
