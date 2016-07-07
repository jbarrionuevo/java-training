package ilan.controllers;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import ilan.enums.SaleStatus;
import ilan.models.CaseWrapper;
import ilan.models.Sale;
import ilan.services.SaleService;

@Controller
@RequestMapping("/storeSellersView")
public class StoreSellerController {

	@Autowired
	SaleService saleService;
	
	@RequestMapping(value="/seller/{sellerId}",method = RequestMethod.GET)
	public String getSalesFromCaseSeller(@PathVariable Long sellerId, Model model){
		Collection<Sale> sales = saleService.getSalesFromCaseSeller(sellerId,"all",0,5);
//		SaleStatus[] status = SaleStatus.values();
		Collection<SaleStatus> storeSellerStatus = new ArrayList<SaleStatus>();
		storeSellerStatus.add(SaleStatus.PAID);
		storeSellerStatus.add(SaleStatus.REFUND);
		long count = saleService.getSalesCountBySeller(sellerId);
		long pageQuantity = count / 5;
		if((count % 5) != 0) pageQuantity++;
		model.addAttribute("sales",sales);
		model.addAttribute("status",storeSellerStatus);
		model.addAttribute("pageQuantity",pageQuantity);
		return "sellerSales";
	}
}
