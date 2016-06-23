package service;

import model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SalesService {
	private InventoryService inventoryService;

	public SalesService(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}

	public void processSell() {
		this.inventoryService.update();
	}

	public void cancelSell() {
		this.inventoryService.update();
	}

	public void draftSell() {
		this.inventoryService.update();
	}

	public void refundSell() {
		this.inventoryService.update();
	}

	public void registerSell(Employee seller) {

	}

	@RequestMapping("/sale")
	public String getSale(@RequestParam(value="name", required=false, defaultValue="test Sale") String name, Model model) {
		model.addAttribute("name", name);
		return "getSale";
	}
}
