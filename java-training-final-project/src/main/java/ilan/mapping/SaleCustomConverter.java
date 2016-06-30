package ilan.mapping;

import java.util.Collection;
import java.util.stream.Collectors;

import org.dozer.CustomConverter;
import org.dozer.Mapper;
import org.dozer.MappingException;
import org.springframework.beans.factory.annotation.Autowired;

import ilan.dtos.CaseOrderDTO;
import ilan.dtos.ReceiptDTO;
import ilan.dtos.SaleDTO;
import ilan.models.CaseOrder;
import ilan.models.Sale;

public class SaleCustomConverter implements CustomConverter{
	
	@Autowired
	private Mapper mapper;
	
	@Override
	public Object convert(Object destination, Object source, 
		      Class destClass, Class sourceClass) {
		// TODO Auto-generated method stub
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
	      CaseOrderDTO orderDTO = mapper.map (sourceSale.getOrder(), CaseOrderDTO.class);
	      Collection<ReceiptDTO> receiptsDTO = sourceSale.getReceipts().stream().map(r->mapper.map(r, ReceiptDTO.class)).collect(Collectors.toList()); 
	      dest.setCaseOrder(orderDTO);
	      dest.setReceipts(receiptsDTO);
	      dest.setStatus(sourceSale.getStatus());
	      return dest;
	    } else if (source instanceof SaleDTO) {
	      SaleDTO sourceSaleDTO = (SaleDTO)source;
	      return new Sale(mapper.map(sourceSaleDTO.getCaseOrder(),CaseOrder.class));
	    } else {
	      throw new MappingException("Converter ProductCustomConverter "
	          + "used incorrectly. Arguments passed in were:"
	          + destination + " and " + source);
	 }
	}
}
