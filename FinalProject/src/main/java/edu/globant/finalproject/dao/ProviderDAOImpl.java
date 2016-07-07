package edu.globant.finalproject.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import edu.globant.finalproject.hibernate.Provider;
import edu.globant.finalproject.model.Provider.ProviderDTO;


@Repository
public class ProviderDAOImpl extends GenericDAOImpl<Provider, Integer> implements ProviderDAO{

	
}
