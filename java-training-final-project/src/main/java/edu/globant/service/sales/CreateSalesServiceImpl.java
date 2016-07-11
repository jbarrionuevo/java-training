package edu.globant.service.sales;

import org.springframework.transaction.annotation.Transactional;
import edu.globant.domain.Sell;
import edu.globant.persistence.DAO.GenericDAO;
import edu.globant.persistence.DAO.SellDAO;
import edu.globant.service.GenericServiceImpl;

public class CreateSalesServiceImpl extends GenericServiceImpl<Long, Sell> implements CreateSalesService{

	private SellDAO sellDAO;

	public CreateSalesServiceImpl(SellDAO dao) {
		sellDAO = dao;
	}

	@Transactional
	public void create(Sell sell) {
		sellDAO.save(sell);
	}

	@Override
	public GenericDAO<Sell> getDao() {
		return sellDAO;
	}
}

