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
//	implements CustomConverter{
	
	@Autowired
	private Mapper mapper;
	
//	@Override
//	public Object convert(Object destination, Object source, 
//		      Class destClass, Class sourceClass) {
		// TODO Auto-generated method stub
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
//	      CaseOrder sourceCaseOrder = (CaseOrder)source;
//	      dest.setDateOfRequest(((CaseOrder) source).getDateOfRequest());
//	      HashMap<Integer,CaseProductDTO> requestCases = new HashMap<Integer,CaseProductDTO>();
//	      for (Map.Entry<CaseProduct, Integer> entry : sourceCaseOrder.getRequestCases().entrySet()){
//	    	  requestCases.put(entry.getValue(), mapper.map(entry.getKey(),CaseProductDTO.class));
//	      }
//	      dest.setRequestCases(requestCases);
//	      return dest;
//	    } else if (source instanceof CaseOrderDTO) {
//	    	CaseOrderDTO sourceCaseOrderDTO = (CaseOrderDTO)source;
//	    	HashMap<CaseProduct,Integer> requestCases = new HashMap<CaseProduct,Integer>();
//		    for (Map.Entry<Integer, CaseProductDTO> entry : sourceCaseOrderDTO.getRequestCases().entrySet()){
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
