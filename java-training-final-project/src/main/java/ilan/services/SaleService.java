package ilan.services;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ilan.daos.CaseSellerDao;
import ilan.daos.SaleDao;
import ilan.exceptions.CaseSellerNotFoundException;
import ilan.models.CaseSeller;
import ilan.models.Sale;

@Service
public class SaleService {
	private final static Logger log = LoggerFactory.getLogger(SaleService.class);

	@Autowired
	private SaleDao saleDao;
	@Autowired
	private CaseSellerDao caseSellerDao;
	
	@Transactional
	public void registerSales(Sale... sales){
		 for (Sale sale: sales) {
	            log.info("Persisting Order [" + sale + "] to database...");
	            saleDao.save(sale);
	     }
	}
	
	public Sale save(Sale newSale){
	    return saleDao.save(newSale);
	}
	
	public Collection<Sale> getSalesFromCaseSeller(Long caseSellerId){
		CaseSeller seller = caseSellerDao.findOne(caseSellerId);
		if(seller==null) throw new CaseSellerNotFoundException(caseSellerId);
		return saleDao.findBySeller(seller);
	}

	
}
