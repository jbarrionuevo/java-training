package ilan.services;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ilan.daos.CaseOrderDao;
import ilan.daos.CaseProductDao;
import ilan.daos.CaseSellerDao;
import ilan.daos.CaseWrapperDao;
import ilan.daos.InventoryDao;
import ilan.daos.SaleDao;
import ilan.enums.SaleStatus;
import ilan.exceptions.CaseProductNotFoundException;
import ilan.exceptions.CaseSellerNotFoundException;
import ilan.exceptions.CaseWrapperNotFoundException;
import ilan.exceptions.NotEnoughStockException;
import ilan.exceptions.SaleNotFoundException;
import ilan.models.CaseOrder;
import ilan.models.CaseProduct;
import ilan.models.CaseSeller;
import ilan.models.CaseWrapper;
import ilan.models.Inventory;
import ilan.models.Receipt;
import ilan.models.Sale;

@Service
public class SaleService {
	private final static Logger log = LoggerFactory.getLogger(SaleService.class);

	@Autowired
	private SaleDao saleDao;
	@Autowired
	private CaseSellerDao caseSellerDao;
	@Autowired
	private CaseWrapperDao caseWrapperDao;
	@Autowired
	private CaseProductDao caseProductDao;
	@Autowired
	private InventoryDao inventoryDao;
	@Autowired
	private CaseOrderDao caseOrderDao;
	
	@Transactional
	public void registerSales(Sale... sales) {
		for (Sale sale : sales) {
			log.info("Persisting Order [" + sale + "] to database...");
			saleDao.save(sale);
		}
	}

	public Sale save(Sale newSale) {
		return saleDao.save(newSale);
	}

	public Long getCount(Long sellerId, String status) {
		CaseSeller seller = caseSellerDao.findOne(sellerId);
		if (seller == null)
			throw new CaseSellerNotFoundException(sellerId);
		if (status == null || status.equals("all"))
			return this.getSalesCountBySeller(sellerId);
		return saleDao.countBySellerAndStatus(seller, this.getStatusFromString(status));
	}

	public Long getSalesCountBySeller(Long sellerId) {
		CaseSeller seller = caseSellerDao.findOne(sellerId);
		if (seller == null)
			throw new CaseSellerNotFoundException(sellerId);
		return saleDao.countBySeller(seller);
	}

	public Collection<Sale> getSalesFromCaseSeller(Long caseSellerId, String status, Integer page, Integer size) {
		CaseSeller seller = caseSellerDao.findOne(caseSellerId);
		if (seller == null)
			throw new CaseSellerNotFoundException(caseSellerId);
		if (status == null || status.equals("all"))
			return saleDao.findBySeller(seller, new PageRequest(page, size));
		return saleDao.findBySellerAndStatus(seller, this.getStatusFromString(status), new PageRequest(page, size));
	}

	private SaleStatus getStatusFromString(String status) {
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

	@Transactional
	public void update(Long saleId, String status) {
		Sale sale = saleDao.findOne(saleId);
		if (sale == null)
			throw new SaleNotFoundException(saleId);
		Inventory inventory = inventoryDao.findAll().get(0);
		Iterator it = sale.getOrder().getRequestCases().entrySet().iterator();
		switch (status) {
		case "paid":
			sale.setStatus(SaleStatus.PAID);
			Receipt receipt = sale.getReceipts().iterator().next();
			receipt.setDateOfSale(new Date());
			sale.getCaseOrder().setDateOfDelivery(new Date());
			while (it.hasNext()) {
				Map.Entry pair = (Map.Entry) it.next();
				CaseProduct product = caseProductDao.findOne((Long) pair.getKey());
				if (product == null)
					throw new CaseProductNotFoundException((Long) pair.getKey());
				CaseWrapper wrapper = caseWrapperDao.findByInventoryAndMyCase(inventory, product);
				if (wrapper == null)
					throw new CaseWrapperNotFoundException(product.toString());
				if(wrapper.getCurrentStock()<(Integer)pair.getValue())
					throw new NotEnoughStockException(product.toString());
				wrapper.setCurrentStock(wrapper.getCurrentStock() - (Integer)pair.getValue());
			}
			break;
		case "cancelled":
			sale.setStatus(SaleStatus.CANCELLED);
			break;
		case "refundSame":
			CaseOrder order = caseOrderDao.findOne(sale.getCaseOrder().getId());
			order.setDateOfRequest(new Date());
			caseOrderDao.save(order);
			break;
		default:
			sale.setStatus(SaleStatus.REFUND);
			//return the case to the inventory
			while (it.hasNext()) {
				Map.Entry pair = (Map.Entry) it.next();
				CaseProduct product = caseProductDao.findOne((Long) pair.getKey());
				if (product == null)
					throw new CaseProductNotFoundException((Long) pair.getKey());
				CaseWrapper wrapper = caseWrapperDao.findByInventoryAndMyCase(inventory, product);
				if (wrapper == null)
					throw new CaseWrapperNotFoundException(product.toString());
				if(wrapper.getCurrentStock()<(Integer)pair.getValue())
					throw new NotEnoughStockException(product.toString());
				wrapper.setCurrentStock(wrapper.getCurrentStock() + (Integer)pair.getValue());
			}
			break;
		}
		inventoryDao.save(inventory);
		saleDao.save(sale);
	}

	public Sale getSale(Long saleId) {
		return saleDao.findOne(saleId);
	}

	public Receipt getSaleReceipt(Long saleId) {
		Sale sale = saleDao.findOne(saleId);
		if (sale == null)
			throw new SaleNotFoundException(saleId);
		return sale.getReceipts().iterator().next();
	}

}
