package ilan.daos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;

import ilan.models.CaseSeller;


public interface CaseSellerDao extends JpaRepository<CaseSeller,Long>{


}
