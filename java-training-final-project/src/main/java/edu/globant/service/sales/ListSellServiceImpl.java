package edu.globant.service.sales;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import edu.globant.domain.Sell;
import edu.globant.persistence.DAO.GenericDAO;
import edu.globant.persistence.DAO.SellDAO;
import edu.globant.service.GenericServiceImpl;
import edu.globant.service.employee.ListEmployeeServiceImpl;

public class ListSellServiceImpl extends GenericServiceImpl<Long, Sell> implements ListSalesService {

	private SellDAO sellDAO;

	@Autowired
	JdbcTemplate jdbcTemplate;

	private final static Logger log = LoggerFactory.getLogger(ListEmployeeServiceImpl.class);

	public ListSellServiceImpl(SellDAO dao) {
		sellDAO = dao;
	}

	public Sell findById(Long id) {
		Sell sell = (Sell) sellDAO.findById(id);
		return sell;
	}

	@Override
	public List<Sell> findAll() {
		return sellDAO.findAll();
	}

	@Override
	public GenericDAO<Sell> getDao() {
		// TODO Auto-generated method stub
		return sellDAO;
	}
}