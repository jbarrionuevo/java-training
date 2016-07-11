package edu.globant.service.sales;

import edu.globant.domain.Sell;
import edu.globant.persistence.DAO.GenericDAO;
import edu.globant.service.GenericServiceImpl;

public class ListSalesServiceImpl extends GenericServiceImpl<Long, Sell> implements ListSalesService {

	@Override
	public GenericDAO<Sell> getDao() {
		// TODO Auto-generated method stub
		return null;
	}

}
