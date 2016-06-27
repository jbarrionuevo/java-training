package ilan.daos;



import org.springframework.data.jpa.repository.JpaRepository;

import ilan.models.Sale;


public interface SaleDao extends JpaRepository<Sale,Long>{

}
