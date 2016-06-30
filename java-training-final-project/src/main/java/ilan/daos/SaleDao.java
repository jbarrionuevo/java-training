package ilan.daos;



import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import ilan.models.CaseSeller;
import ilan.models.Sale;


public interface SaleDao extends JpaRepository<Sale,Long>{
	Collection<Sale> findBySeller(CaseSeller seller);
}
