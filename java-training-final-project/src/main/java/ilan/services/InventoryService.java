package ilan.services;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ilan.daos.InventoryDao;

@Service
public class InventoryService {
	
	@Autowired
	private InventoryDao inventoryDao;

}