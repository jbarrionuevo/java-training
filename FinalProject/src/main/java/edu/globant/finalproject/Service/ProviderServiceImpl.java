package edu.globant.finalproject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.globant.finalproject.dao.GenericDAO;
import edu.globant.finalproject.dao.ProviderDAO;
import edu.globant.finalproject.hibernate.Provider;
import edu.globant.finalproject.model.Provider.ProviderDTO;

@Service
public class ProviderServiceImpl extends GenericServiceImpl<Provider, Integer> implements ProviderService{
	
	private ProviderDAO providerDAO;
	public ProviderServiceImpl() {}
	
	@Autowired
    public ProviderServiceImpl(
            @Qualifier("providerDAOImpl") GenericDAO<Provider, Integer> genericDao) {
        super(genericDao);
        this.providerDAO = (ProviderDAO) genericDao;
    }
}
