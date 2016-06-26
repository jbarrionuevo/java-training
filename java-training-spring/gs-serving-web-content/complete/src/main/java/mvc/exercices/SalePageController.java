package mvc.exercices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mvc.exercices.services.sale.SaleService;

@Controller
public class SalePageController {
	
	@Autowired
	SaleService saleService;
	
    @RequestMapping("/todaysales")
    public String getTodaySales(@RequestParam(value="employeeName", required=false, defaultValue="") String name, Model model) {
    	
    	if(name.equals("")) {
    		model.addAttribute("sales", saleService.getAllSales());
    	}
    	else {
    		model.addAttribute("sales", saleService.getAllSalesByName(name));
    	}
    	return "todaysales";
    }   	
}
