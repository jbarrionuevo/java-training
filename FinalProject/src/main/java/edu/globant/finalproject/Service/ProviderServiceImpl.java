package edu.globant.finalproject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import edu.globant.finalproject.dao.GenericDAO;
import edu.globant.finalproject.dao.ProviderDAO;
import edu.globant.finalproject.model.Provider.ProviderDTO;

public class ProviderServiceImpl extends GenericServiceImpl<ProviderDTO, Integer> implements ProviderService{
	private ProviderDAO providerDAO;
	public ProviderServiceImpl() {}
	
	@Autowired
    public ProviderServiceImpl(
            @Qualifier("providerDAOImpl") GenericDAO<ProviderDTO, Integer> genericDao) {
        super(genericDao);
        this.providerDAO = (ProviderDAO) genericDao;
    }
}
