package ilan.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import ilan.exceptions.CaseDesignNotFoundException;
import ilan.models.Case;
import ilan.models.CaseDesign;
import ilan.services.CaseDesignService;
import ilan.services.CaseService;


@Controller
@RequestMapping("/cases")
public class CaseController {

	@Autowired
	CaseService caseService;
	@Autowired
	CaseDesignService caseDesignService;
	
//	@RequestMapping("/cases")
	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(value= HttpStatus.OK)
    public String findAll(Model model) {
		Collection<CaseDesign> allDesigns = caseDesignService.findAllCaseDesignes();
    	Collection<Case> cases = caseService.findAllCases();
    	model.addAttribute("cases",cases);
    	model.addAttribute("designs",allDesigns);
        return "cases";
    }
	
	@RequestMapping("/design/{design}")
	@ResponseStatus(value= HttpStatus.OK)
    public String findWithDesign(@PathVariable String design, Model model) {
    	CaseDesign askedDesign = caseDesignService.findByName(design);
    	if (askedDesign==null) throw new CaseDesignNotFoundException(design);
		Collection<Case> cases = caseService.findCasesWithDesign(askedDesign);
    	model.addAttribute("cases",cases);
        return "cases";
    }
}
