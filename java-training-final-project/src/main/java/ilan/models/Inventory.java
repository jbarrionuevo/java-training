package ilan.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Inventory {
//implements InventorySubject{
	
	@Id
	@GeneratedValue
	private Long id;
	
	private static Inventory instance = null;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "inventory", cascade = CascadeType.ALL)
	private static Collection<CaseWrapper> stock;
	
//	@OneToMany
//	private Set<InventoryObserver> inventoryObservers;

	private Inventory() {
		this.stock = new ArrayList<CaseWrapper>();
//		this.inventoryObservers = new HashSet<InventoryObserver>();
	}

	public static Inventory getInstance() {
		if (instance == null) {
			instance = new Inventory();
		}
		return instance;
	}
	
	public static void addCase(CaseProduct aCase, int quantity){
		//if inventory has a CaseWrapper for that type of case
			//update it
		//else
		   //create new casewrapper for that type of case, then update it
	}
	
	public static void removeCase(CaseProduct aCase, int quantity){
		//if inventory has a CaseWrapper for that type of case
			//update it
		//else
			//throw not found
	}

//	@Override
//	public void addObserver(InventoryObserver inventoryObserver) {
//		inventoryObservers.add(inventoryObserver);
//	}
//
//	@Override
//	public void removeObserver(InventoryObserver inventoryObserver) {
//		inventoryObservers.remove(inventoryObserver);
//	}

	private CaseWrapper getWrapperForCase(CaseProduct aCase){
		//return the wrapper for that case, which include its minimum stock and current stock
		return null;
	}
//	@Override
//	public void doNotify(Case aCase) {
//		Iterator<InventoryObserver> it = inventoryObservers.iterator();
//		CaseWrapper wrapperUpdated = getWrapperForCase(aCase);
//		if(wrapperUpdated.getCurrentStock()<wrapperUpdated.getCurrentStock()){
//			while (it.hasNext()) {
//				InventoryObserver inventoryObserver = it.next();
//				inventoryObserver.doUpdate(aCase);
//			}
//		}
//	}
	
	
}
