package ilan.threads;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import ilan.daos.CaseWrapperDao;
import ilan.daos.OrderAlertDao;
import ilan.models.CaseWrapper;
import ilan.models.OrderAlert;

@Component
public class AlarmThread {
	@Autowired
	CaseWrapperDao caseWrapperDao;
	@Autowired
	OrderAlertDao orderAlertDao;
	
	 @Scheduled(fixedRate = 1000)
	 public void checkAlarms() {
		 Collection<CaseWrapper> wrappers = caseWrapperDao.findAll();
		 for(CaseWrapper wr : wrappers){
			 if(wr.getCurrentStock()<wr.getMinimumStock()){ /**if there's lack of stock, and there's not an existing order of this product, it generates one**/
				 if(orderAlertDao.findByProductId(wr.getMyCase().getId())==null)
					 orderAlertDao.save(new OrderAlert(wr.getMinimumStock()-wr.getCurrentStock()+100, wr.getMyCase()));
			 }else{ /** if there's an order to the prpvider for a product, but this has already been replaced, then the order is deleted **/
				 OrderAlert orderAlert = orderAlertDao.findByProductId(wr.getMyCase().getId());
				 if( (orderAlert!=null) && (orderAlert.isMade()))
					 orderAlertDao.delete(orderAlert);
			 }
				 
		 }
		
	 }
}