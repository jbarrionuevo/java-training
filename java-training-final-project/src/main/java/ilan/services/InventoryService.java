package ilan.services;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import ilan.daos.CaseOrderDao;
import ilan.daos.CaseProductDao;
import ilan.daos.CaseWrapperDao;
import ilan.daos.InventoryDao;
import ilan.exceptions.CaseProductNotFoundException;
import ilan.exceptions.CaseWrapperNotFoundException;
import ilan.exceptions.OrderAlreadyProcessedException;
import ilan.exceptions.OrderNotFoundException;
import ilan.models.CaseProduct;
import ilan.models.CaseWrapper;
import ilan.models.CaseDesign;
import ilan.models.CaseDevice;
import ilan.models.CaseOrder;
import ilan.models.Inventory;
import ilan.models.Provider;

@Service
public class InventoryService {
	
	private final static Logger log = LoggerFactory.getLogger(InventoryService.class);

	@Autowired
	private InventoryDao inventoryDao;
	
	@Autowired
	private CaseWrapperDao caseWrapperDao;
	
	@Autowired
	private CaseProductDao caseProductDao;
	
	@Autowired
	private CaseOrderDao caseOrderDao;
		
	public Inventory getInventory(){
		return inventoryDao.findAll().get(0);
	}
	
	public Collection<CaseWrapper> getInventoryWrappers(Integer page, Integer size){
		return caseWrapperDao.findByInventory(this.getInventory(),new PageRequest(page, size));
	}
	
	public Long getInventoryCount(){
		return caseWrapperDao.countByInventory(this.getInventory());
	}
	
	public Long getCount(String design, String device){
		if ( (design==null || design.equals("all")) && (device==null || device.equals("all"))) return this.getInventoryCount();
		if(device==null || device.equals("all")) return caseWrapperDao.countByInventoryAndMyCaseDesignName(this.getInventory(),design);
		if(design==null ||  design.equals("all")) return caseWrapperDao.countByInventoryAndMyCaseDeviceName(this.getInventory(),device);
		return caseWrapperDao.countByInventoryAndMyCaseDesignNameAndMyCaseDeviceName(this.getInventory(),design,device);
	}
	
	public Collection<CaseDesign> getDesigns(){
		return inventoryDao.findAll().get(0).getStock()
	    		.stream()
	    		.map(cw -> cw.getMyCase()).collect(Collectors.toList())
	    		.stream()
	    		.collect(Collectors.groupingBy(CaseProduct::getDesign)).keySet();
	}
	
	public Collection<CaseDevice> getDevices() {
		return inventoryDao.findAll().get(0).getStock()
	    		.stream()
	    		.map(cw -> cw.getMyCase()).collect(Collectors.toList())
	    		.stream()
	    		.collect(Collectors.groupingBy(CaseProduct::getDevice)).keySet();
	}
	
	public void setMinimumStock(int minimumStock, CaseProduct aCase){
		CaseWrapper wrapper = caseWrapperDao.findByMyCase(aCase);
		if(wrapper==null) throw new CaseWrapperNotFoundException(aCase.toString());
		wrapper.setMinimumStock(minimumStock);
		caseWrapperDao.save(wrapper);
	}
	
	public void incrementStock(CaseProduct aCase, int quantity, int minimumStock){
		Inventory inventory = this.getInventory();
		try{
			CaseWrapper wrapper = this.getInventory().getStock().stream().filter(cw->cw.getMyCase().equals(aCase)).collect(Collectors.toList()).get(0);
			wrapper.setCurrentStock(wrapper.getCurrentStock()+quantity);
			caseWrapperDao.save(wrapper);
		}catch(IndexOutOfBoundsException e){
			if(caseProductDao.findByDesignAndDevice(aCase.getDesign(),aCase.getDevice())==null) caseProductDao.save(aCase);
			inventory.addCase(aCase, quantity,minimumStock);
			inventoryDao.save(inventory);
		}
	}
	
	public Collection<CaseWrapper> getInventoryWithDesignAndDevice(String design,String device,Integer page, Integer size) {
		if( (design.equals("all")) && (device.equals("all"))) return this.getInventoryWrappers(page,size);
		if (design.equals("all")) return this.getInventoryWithDevice(device,page,size);
		if (device.equals("all")) return this.getInventoryWithDesign(design,page,size);
		return caseWrapperDao.findByInventoryAndMyCaseDesignNameAndMyCaseDeviceName(this.getInventory(),design,device,new PageRequest(page, size));
	}
	
	@Transactional
	public String buyProducts(Map<Long,Integer> desire) {
		for (Map.Entry<Long, Integer> entry : desire.entrySet()){
			CaseWrapper looked = caseWrapperDao.findOne(entry.getKey());
			if(looked==null) return "Error: Case not found";
			if(looked.getCurrentStock()<entry.getValue()) return "That quantity of "+looked.getMyCase().getDesign().getName()+", "+looked.getMyCase().getDevice().getName()+" is not available!";
			looked.setCurrentStock(looked.getCurrentStock()-entry.getValue());
			if(looked.getMinimumStock()>looked.getCurrentStock()){
				//generateOrder(looked);
			}
			caseWrapperDao.save(looked);
		}
		return "Case successfully bought!";
	}
	
	@Transactional
	public void supplyStock(Long orderId) {
		CaseOrder order = caseOrderDao.findOne(orderId);
		if(order==null) throw new OrderNotFoundException(orderId);
		if(order.getDateOfDelivery()!=null) throw new OrderAlreadyProcessedException(orderId);
		order.setDateOfDelivery(new Date());
		Inventory inventory = this.getInventory();
		Iterator it = order.getRequestCases().entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        CaseProduct product = caseProductDao.findOne(Long.parseLong((String)pair.getKey()));
	        if(product==null) throw new CaseProductNotFoundException(Long.parseLong((String)pair.getKey()));
	        CaseWrapper wrapper = caseWrapperDao.findByInventoryAndMyCase(inventory, product);
	        if(wrapper==null) throw new CaseWrapperNotFoundException(product.toString());
	        wrapper.setCurrentStock(wrapper.getCurrentStock()+((Integer)pair.getValue()));
//	        caseWrapperDao.save(wrapper);
	    }
	    inventoryDao.save(inventory);
	}
	
	public Collection<CaseWrapper> getInventoryWithDesign(String design,Integer page, Integer size) {
		return caseWrapperDao.findByInventoryAndMyCaseDesignName(this.getInventory(),design,new PageRequest(page, size));
	}
	
	public Collection<CaseWrapper> getInventoryWithDevice(String device,Integer page, Integer size) {
		return caseWrapperDao.findByInventoryAndMyCaseDeviceName(this.getInventory(),device,new PageRequest(page, size));
	}
	
	public void decrementStock(CaseDesign design, CaseDevice device, int quantity){
		System.out.println("update stock for cases with those parameters");
	}
	
	public int caseAmountFromProvider(Provider provider){
		System.out.println("return the number of cases provided by a specific provider");
		return 0;
	}
	
	public InventoryDao getInventoryDao() {
		return inventoryDao;
	}

	public void setInventoryDao(InventoryDao inventoryDao) {
		this.inventoryDao = inventoryDao;
	}

	public CaseWrapperDao getCaseWrapperDao() {
		return caseWrapperDao;
	}

	public void setCaseWrapperDao(CaseWrapperDao caseWrapperDao) {
		this.caseWrapperDao = caseWrapperDao;
	}

	public CaseOrderDao getCaseOrderDao() {
		return caseOrderDao;
	}

	public void setCaseOrderDao(CaseOrderDao caseOrderDao) {
		this.caseOrderDao = caseOrderDao;
	}

	

	

	

}