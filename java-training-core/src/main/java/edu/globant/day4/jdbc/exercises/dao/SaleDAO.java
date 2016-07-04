package edu.globant.day4.jdbc.exercises.dao;

import java.util.List;

import edu.globant.day4.jdbc.exercises.sale.Sale;

public class SaleDAO implements GenericDAO<Long, Sale>{

	DataSource ds;
	
	@Override
	public Long create(Sale newInstance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sale read(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Sale transientObject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Sale persistentObject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Sale getByIndex(Long index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sale> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
