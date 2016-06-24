package edu.globant.day6.exercises.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import edu.globant.day6.exercises.model.Case;
import edu.globant.day6.exercises.model.Design;
import edu.globant.day6.exercises.model.Device;
import edu.globant.day6.exercises.services.CaseService;


@SpringBootApplication
public class Application {

		
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		CaseService caseService = ctx.getBean(CaseService.class);
		caseService.saveCase(new Case(new Design("Designname"),new Device("Devicename"),10.0,21));
	}

}
