package edu.globant.IONSolid.services.sale;

import java.util.Map;

import edu.globant.IONSolid.model.sale.Sale;
import edu.globant.IONSolid.services.sale.exception.SaleServiceException;

public interface SaleService {

	public void registerASaleDraft(Sale sale) throws SaleServiceException;

	public Sale getASale(Long saleId) throws SaleServiceException;

	public void registerAPayment(Sale sale) throws SaleServiceException;

	public void cancelASale(Sale sale) throws SaleServiceException;

	public void refundASale(Sale sale) throws SaleServiceException;

	public Map<Long, Sale> getAllRegisteredSales();
}
