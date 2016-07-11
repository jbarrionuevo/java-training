package edu.globant.persistence.DAO;

import java.util.List;

import org.hibernate.Session;
import edu.globant.domain.Sell;

public class SellDAOImpl extends AbstractDAO<Sell> implements SellDAO {

	public SellDAOImpl(Session session) {
		super(session);
	}

	@Override
	public void save(Sell entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public Sell findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Sell entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Sell entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Sell> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
