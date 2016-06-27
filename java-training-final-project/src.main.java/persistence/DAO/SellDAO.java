package persistence.DAO;

import java.util.List;

import domain.Employee;
import domain.Sell;

public class SellDAO implements DAO {

	public List<Sell> findAll() {
		return null;

	};

	public List<Sell> findById() {
		return null;

	};

	public List<Sell> findByName() {
		return null;

	};

	@Override
	public boolean insert(DTO dto) {
		Sell sell = (Sell) dto;
		// TODO Auto-generated method stub
		// db.save(sell);
		return false;
	}

	@Override
	public boolean update(DTO dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(DTO dto) {
		// TODO Auto-generated method stub
		return false;
	}
}
