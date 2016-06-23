package exercices.day6.spring_mvc.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import exercices.day6.dependency_injection.models.Case;
import exercices.day6.dependency_injection.services.CaseService;

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
