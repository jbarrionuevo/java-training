package dia1.services;

import dia1.daos.SaleDao;
import dia1.enums.SaleStatus;
import dia1.models.Sale;

public class SaleService {
	
	private SaleDao saleDao;

	public void registerSale(Sale sale){
		System.out.println("Saving sale");
		//saleDao.save(sale);
	}
	
	public void cancelSale(Sale sale){
		sale.setStatus(SaleStatus.CANCELLED);
		System.out.println("Cancelling sale");
		//update sale in db
	}
	
	public void markAsPaid(Sale sale){
		System.out.println("Paying sale");
		sale.setStatus(SaleStatus.PAID);
		//update sale in db
	}
	
	public void refundSale(Sale sale){
		System.out.println("Refund sale");
		sale.setStatus(SaleStatus.REFUND);
		//update sale in db
	}
	
	public SaleDao getSaleDao() {
		return saleDao;
	}

	public void setSaleDao(SaleDao saleDao) {
		this.saleDao = saleDao;
	}
	
}
