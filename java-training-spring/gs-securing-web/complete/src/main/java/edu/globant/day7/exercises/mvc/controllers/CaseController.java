package edu.globant.day7.exercises.mvc.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import edu.globant.day6.exercises.model.Case;
import edu.globant.day6.exercises.services.CaseService;


@Controller
public class CaseController {
	@Autowired
	CaseService caseService;
	
	@RequestMapping("/cases")
    public String findAll(Model model) {
    	Collection<Case> cases = caseService.findAllCases();
    	model.addAttribute("cases",cases);
        return "cases";
    }
}


