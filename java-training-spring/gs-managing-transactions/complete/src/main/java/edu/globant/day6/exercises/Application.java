package edu.globant.day6.exercises;

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
		Design des = new Design("adesign");
		Device dev = new Device("adevice");
		Case c = new Case(des, dev,10.0, 21);
		caseService.saveCase(c);
	}

}
