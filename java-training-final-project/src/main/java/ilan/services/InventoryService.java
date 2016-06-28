package ilan.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ilan.daos.CaseProductDao;
import ilan.daos.CaseWrapperDao;
import ilan.daos.InventoryDao;
import ilan.models.CaseProduct;
import ilan.models.CaseWrapper;
import ilan.models.CaseDesign;
import ilan.models.CaseDevice;
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
	
//	public void addCase(Case aCase, int quantity){
//		Inventory inventory = Inventory.getInstance();
//		inventory.addCase(aCase, quantity);
//		//update inventory in db
//	}
	
//	public void removeCase(Case aCase, int quantity){
//		Inventory inventory = Inventory.getInstance();
//		inventory.removeCase(aCase, quantity);
//		inventory.doNotify(aCase);
//		//trigger alarm if the case stock is less than a minimum number
//		//update inventory in db
//	}
//	
	
	public Inventory getInventory(){
		return inventoryDao.findAll().get(0);
	}
	
	public Collection<CaseWrapper> getInventoryWrappers(){
		return inventoryDao.findAll().get(0).getStock();
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
	
	public int caseStock(CaseDesign design, CaseDevice device){
		System.out.println("return the number of cases with those parameters");
		return 0;
	}
	
	public void incrementStock(CaseProduct aCase, int quantity){
		Inventory inventory = this.getInventory();
		try{
			CaseWrapper wrapper = this.getInventory().getStock().stream().filter(cw->cw.getMyCase().equals(aCase)).collect(Collectors.toList()).get(0);
//			CaseWrapper wrapper = caseWrapperDao.findOne(lookingFor.getId());
			wrapper.setCurrentStock(wrapper.getCurrentStock()+quantity);
			caseWrapperDao.save(wrapper);
		}catch(IndexOutOfBoundsException e){
			if(caseProductDao.findByDesignAndDevice(aCase.getDesign(),aCase.getDevice())==null) caseProductDao.save(aCase);
			inventory.addCase(aCase, quantity);
			inventoryDao.save(inventory);
		}
	}
	
	public Collection<CaseWrapper> getInventoryWithDesignAndDevice(String design,String device) {
		if( (design.equals("all")) && (device.equals("all"))) return this.getInventoryWrappers();
		if (design.equals("all")) return this.getInventoryWithDevice(device);
		if (device.equals("all")) return this.getInventoryWithDesign(design);
		return this.getInventory().getStock().stream()
					.filter(cw->
							cw.getMyCase().getDesign().equals(new CaseDesign(design)) && 
							cw.getMyCase().getDevice().equals(new CaseDevice(device)))
					.collect(Collectors.toList());
	}
	
	public Collection<CaseWrapper> getInventoryWithDesign(String design) {
		return this.getInventory().getStock().stream().filter(cw->cw.getMyCase().getDesign().equals(new CaseDesign(design))).collect(Collectors.toList());
	}
	
	public Collection<CaseWrapper> getInventoryWithDevice(String device) {
		return this.getInventory().getStock().stream().filter(cw->cw.getMyCase().getDevice().equals(new CaseDevice(device))).collect(Collectors.toList());
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

	

	

}