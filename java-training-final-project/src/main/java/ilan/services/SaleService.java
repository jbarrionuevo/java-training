package ilan.services;

import java.util.Collection;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ilan.daos.CaseSellerDao;
import ilan.daos.SaleDao;
import ilan.enums.SaleStatus;
import ilan.exceptions.CaseSellerNotFoundException;
import ilan.exceptions.SaleNotFoundException;
import ilan.models.CaseSeller;
import ilan.models.Receipt;
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
	
	public Long getCount(Long sellerId, String status){
		CaseSeller seller = caseSellerDao.findOne(sellerId);
		if(seller==null) throw new CaseSellerNotFoundException(sellerId);
		if (status==null || status.equals("all")) return this.getSalesCountBySeller(sellerId);
		return saleDao.countBySellerAndStatus(seller, this.getStatusFromString(status));
	}
	
	public Long getSalesCountBySeller(Long sellerId){
		CaseSeller seller = caseSellerDao.findOne(sellerId);
		if(seller==null) throw new CaseSellerNotFoundException(sellerId);
		return saleDao.countBySeller(seller);
	}
	
	public Collection<Sale> getSalesFromCaseSeller(Long caseSellerId,String status,Integer page, Integer size){
		CaseSeller seller = caseSellerDao.findOne(caseSellerId);
		if(seller==null) throw new CaseSellerNotFoundException(caseSellerId);
		if (status==null || status.equals("all")) return saleDao.findBySeller(seller,new PageRequest(page, size));
		return saleDao.findBySellerAndStatus(seller,this.getStatusFromString(status),new PageRequest(page, size));
	}
	
	private SaleStatus getStatusFromString(String status){
		switch (status.toLowerCase()) {
		case "paid":
			return SaleStatus.PAID;
		case "cancelled":
			return SaleStatus.CANCELLED;
		case "refund":
			return SaleStatus.REFUND;
		default:
			return SaleStatus.DRAFT;
		}
	}

	public void update(Long saleId, String status) {
		Sale sale = saleDao.findOne(saleId);
		if(sale==null) throw new SaleNotFoundException(saleId);
		switch (status) {
		case "paid":
			sale.setStatus(SaleStatus.PAID);
			Receipt receipt = sale.getReceipts().iterator().next();
			receipt.setDateOfSale(new Date());
			break;
		case "cancelled":
			sale.setStatus(SaleStatus.CANCELLED);
			break;
		default:
			sale.setStatus(SaleStatus.REFUND);
			break;
		}
		saleDao.save(sale);
	}

	public Sale getSale(Long saleId) {
		return saleDao.findOne(saleId);
	}

	
}
