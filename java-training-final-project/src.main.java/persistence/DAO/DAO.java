package persistence.DAO;

import java.util.List;
import domain.Sell;

public interface DAO {
	List<Sell> findAll();

	List<Sell> findById();

	List<Sell> findByName();

	boolean insert(DTO dto);

	boolean update(DTO dto);

	boolean delete(DTO dto);
}
