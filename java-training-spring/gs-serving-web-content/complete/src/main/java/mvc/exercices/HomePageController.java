package mvc.exercices;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomePageController {

    @RequestMapping("/home")
    public String home() {
        return "home";
    }
    
    @RequestMapping("/saleredirect")
    public String getTodaySales(@RequestParam(value="employeeName", required=false, defaultValue="") String name, RedirectAttributes redirectAttributes) {
    	redirectAttributes.addAttribute("employeeName", name);
        return "redirect:todaysales";
    }   
}
