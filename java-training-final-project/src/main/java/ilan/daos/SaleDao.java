package ilan.daos;



import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import ilan.enums.SaleStatus;
import ilan.models.CaseSeller;
import ilan.models.Sale;


public interface SaleDao extends JpaRepository<Sale,Long>{
	List<Sale> findBySeller(CaseSeller seller,Pageable pageable);
	List<Sale> findBySellerAndStatus(CaseSeller seller,SaleStatus status, Pageable pageable);
	long countBySeller(CaseSeller seller);
	long countBySellerAndStatus(CaseSeller seller, SaleStatus status);
	
}
