package ilan.controllers;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
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
@RequestMapping("/sellersView")
public class SellerController {

	@Autowired
	SaleService saleService;
	
	@RequestMapping(value="/seller/{sellerId}/sales",method = RequestMethod.GET)
	public String getSalesFromCaseSeller(@PathVariable Long sellerId, Model model){
		Collection<Sale> sales = saleService.getSalesFromCaseSeller(sellerId,"all",0,5);
		long count = saleService.getSalesCountBySeller(sellerId);
		long pageQuantity = count / 5;
		if((count % 5) != 0) pageQuantity++;
		
		Collection<SaleStatus> status = new ArrayList<SaleStatus>() {{add(SaleStatus.PAID);add(SaleStatus.REFUND);}};
		Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        if (hasDeliveryAuthority(authorities)){
            status.add(SaleStatus.DRAFT);
	    	status.add(SaleStatus.CANCELLED);
        }
	      
		model.addAttribute("sales",sales);
		model.addAttribute("status",status);
		model.addAttribute("pageQuantity",pageQuantity);
		return "sellerSales";
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String registerSales(Model model){
		SaleStatus[] status = SaleStatus.values();
		model.addAttribute("status",status);
		return "deliverySellerRegister";
	}
	
	private boolean hasDeliveryAuthority(Collection<SimpleGrantedAuthority> authorities){
		for (GrantedAuthority auth : authorities) {
            if ("ROLE_DELIVERY_SELLER".equals(auth.getAuthority())){
            	return true;
            }
        }
		return false;
	}
}
