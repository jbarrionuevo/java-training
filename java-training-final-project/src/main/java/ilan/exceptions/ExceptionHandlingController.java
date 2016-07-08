package ilan.exceptions;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ExceptionHandlingController implements ErrorController{
	
	 private static final String PATH = "/error";

	    @RequestMapping(value = PATH)
	    public String error() {
	        return "error";
	    }

	    @Override
	    public String getErrorPath() {
	        return PATH;
	    }

}
