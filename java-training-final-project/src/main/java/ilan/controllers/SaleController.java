package ilan.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import ilan.models.CaseWrapper;
import ilan.models.Sale;
import ilan.services.SaleService;

@Controller
@RequestMapping("/salesView")
public class SaleController {

	@Autowired
	SaleService saleService;
	
	@RequestMapping(value="/seller/{sellerId}",method = RequestMethod.GET)
	@ResponseStatus(value= HttpStatus.OK)
	public String getSalesFromCaseSeller(@PathVariable Long sellerId, Model model){
		Collection<Sale> sales = saleService.getSalesFromCaseSeller(sellerId);
		model.addAttribute("sales",sales);
		model.addAttribute("requestCases",null);
		return "sellerSales";
	}
}
