package edu.globant.day2.exercises.designPatterns;

/*
 * I use the facade pattern to have an unique 
 * interface between the view layer and the service
 * one
 * */
public class ServiceFacade {
	
	ApplicationServiceMode appService;
	
	public Tweet execute(Configuration conf) {
		if(conf.getMode()) {
			appService = new OnLineService();
		} else {
			appService = new OffLineService();
		}
		
		return appService.executeQuery(conf.getUserName());
	}
}
