package ilan.mapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dozer.CustomConverter;
import org.dozer.MappingException;

import ilan.dtos.CaseOrderDTO;
import ilan.dtos.CustomerDTO;
import ilan.dtos.ReceiptDTO;
import ilan.dtos.SaleDTO;
import ilan.models.CaseOrder;
import ilan.models.Customer;
import ilan.models.Receipt;
import ilan.models.Sale;

public class SaleCustomConverter implements CustomConverter{
	@Override
	public Object convert(Object destination, Object source, 
		      Class destClass, Class sourceClass) {
		if (source == null) {
		      return null;
		}
		SaleDTO dest = null;
	    if (source instanceof Sale) {
	      if (destination == null) {
	        dest = new SaleDTO();
	      } else {
	        dest = (SaleDTO) destination;
	      }
	      Sale sourceSale = (Sale)source;
	      HashMap<String,Integer> requestCases = new HashMap<String,Integer>();
	      Iterator it = sourceSale.getOrder().getRequestCases().entrySet().iterator();
	      while (it.hasNext()) {
	          Map.Entry pair = (Map.Entry)it.next();
	          requestCases.put(Long.toString((long) pair.getKey()), (Integer)pair.getValue());
	      }
	      CaseOrderDTO caseOrder = new CaseOrderDTO(requestCases, sourceSale.getOrder().getDateOfRequest());
	      Collection<ReceiptDTO> receipts = new ArrayList<ReceiptDTO>();
	      for(Receipt receipt: sourceSale.getReceipts()){
	    	  Customer c = receipt.getCustomer();
	    	  receipts.add(new ReceiptDTO(receipt.getStoreName(), receipt.getDateOfSale(), new CustomerDTO(c.getName(), c.getLocation(), c.getAge(), c.getGender())));
	      }
	      SaleDTO result = new SaleDTO(caseOrder,receipts,sourceSale.getTotalPrice(), sourceSale.getStatus());
	      result.setId(sourceSale.getId());
	      result.setStatus(sourceSale.getStatus());
	      return result;
	    } else if (source instanceof SaleDTO) {
	    	SaleDTO sourceSaleDTO = (SaleDTO)source;
	    	HashMap<Long,Integer> requestCases = new HashMap<Long,Integer>();
		    Iterator it = sourceSaleDTO.getCaseOrder().getRequestCases().entrySet().iterator();
		      while (it.hasNext()) {
		          Map.Entry pair = (Map.Entry)it.next();
		          requestCases.put(Long.parseLong((String) pair.getKey()), (Integer)pair.getValue());
		    }
		    CustomerDTO sourceCustomer = sourceSaleDTO.getReceipts().iterator().next().getCustomer();
		    Customer customer = new Customer(sourceCustomer.getName(), sourceCustomer.getLocation(), sourceCustomer.getAge(), sourceCustomer.getGender());
	    	CaseOrder caseOrder = new CaseOrder(requestCases, sourceSaleDTO.getCaseOrder().getDateOfRequest(), customer);
	    	Collection<Receipt> receipts = new ArrayList<Receipt>();
		    for(ReceiptDTO receiptDTO: sourceSaleDTO.getReceipts()){
		    	  CustomerDTO c = receiptDTO.getCustomer();
		    	  receipts.add(new Receipt(receiptDTO.getStoreName(), receiptDTO.getDateOfSale(), new Customer(c.getName(), c.getLocation(), c.getAge(), c.getGender())));
		    }
		    Sale result = new Sale(caseOrder, receipts, sourceSaleDTO.getTotalPrice(), sourceSaleDTO.getStatus());
		    result.setStatus(sourceSaleDTO.getStatus());
	    	return result;
	    } else {
	      throw new MappingException("Converter ProductCustomConverter "
	          + "used incorrectly. Arguments passed in were:"
	          + destination + " and " + source);
	 }
	}
	
}
