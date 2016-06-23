package exercices.day6.dependency_injection.services;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exercices.day6.dependency_injection.daos.InventoryDao;

@Service
public class InventoryService {
	
	@Autowired
	private InventoryDao inventoryDao;

}