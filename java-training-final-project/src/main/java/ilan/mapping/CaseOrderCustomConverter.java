package ilan.mapping;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.dozer.CustomConverter;
import org.dozer.Mapper;
import org.dozer.MappingException;
import org.springframework.beans.factory.annotation.Autowired;

import ilan.dtos.CaseOrderDTO;
import ilan.dtos.CaseProductDTO;
import ilan.dtos.ReceiptDTO;
import ilan.dtos.SaleDTO;
import ilan.models.CaseOrder;
import ilan.models.CaseProduct;
import ilan.models.Sale;

public class CaseOrderCustomConverter {
//implements CustomConverter{
	
	
//	@Override
//	public Object convert(Object destination, Object source, 
//		      Class destClass, Class sourceClass) {
//		if (source == null) {
//		      return null;
//		}
//		CaseOrderDTO dest = null;
//	    if (source instanceof CaseOrder) {
//	      if (destination == null) {
//	        dest = new CaseOrderDTO();
//	      } else {
//	        dest = (CaseOrderDTO) destination;
//	      }
//	      
//	      CaseOrder sourceCaseOrder = (CaseOrder)source;
//	      dest.setDateOfRequest(((CaseOrder) source).getDateOfRequest());
//	      
//	      HashMap<String,Integer> requestCases = new HashMap<String,Integer>();
//	      for (Map.Entry<Long, Integer> entry : sourceCaseOrder.getRequestCases().entrySet()){
//	    	  requestCases.put(String.valueOf(entry.getKey()), entry.getValue());
//	      }
//	      dest.setRequestCases(requestCases);
//	      return dest;
//	    } else if (source instanceof CaseOrderDTO) {
//	    	CaseOrderDTO sourceCaseOrderDTO = (CaseOrderDTO)source;
//	    	HashMap<Long,Integer> requestCases = new HashMap<Long,Integer>();
//		    for (Map.Entry<String, Integer> entry : sourceCaseOrderDTO.getRequestCases().entrySet()){
//		    	
//		    	  requestCases.put(mapper.map(entry.getValue(),CaseProduct.class),entry.getKey());
//		    }
//	    	return new CaseOrder(requestCases, sourceCaseOrderDTO.getDateOfRequest());
//	    } else {
//	      throw new MappingException("Converter ProductCustomConverter "
//	          + "used incorrectly. Arguments passed in were:"
//	          + destination + " and " + source);
//	 }
//	}
}
