package edu.globant.day7.exercises.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String home(@RequestParam(value="name", required=false, defaultValue="Guest") String name, Model model) {
        name="un nombre";
    	model.addAttribute("name", name);
        return "index";
    }
    
    @RequestMapping("/login")
    public String handleLogin() {
		return "login";
    }
    
}