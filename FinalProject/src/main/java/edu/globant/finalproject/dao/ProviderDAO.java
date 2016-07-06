package edu.globant.finalproject.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import edu.globant.finalproject.model.Provider.ProviderDTO;

public interface ProviderDAO extends GenericDAO<ProviderDTO, Integer>{

}
