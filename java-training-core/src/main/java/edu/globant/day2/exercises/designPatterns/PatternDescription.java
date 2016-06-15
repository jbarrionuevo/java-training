package edu.globant.day2.exercises.designPatterns;

public class PatternDescription {

	/*
	 * On this package I explain a combination of the facade pattern
	 * and the strategy Pattern that I used once on a project related
	 * to recover tweets from Twitter. On this application you could
	 * recover data online by using the online mode (OnlineService) or
	 * you could recover data from a database of tweets (OfflineService)
	 * 
	 * To make an interface between the GUI and the service layer I used
	 * the facade pattern which would contain an ApplicationServiceMode
	 * which would be the different modes on which the application could 
	 * run. Based on a configuration that was received from the GUI the
	 * facade knows which of the two configurations to set and then
	 * execute the same method with the same interface that was set on 
	 * the ApplicationServiceMode for both modes. Depending of the mode
	 * that was set the data would come from the database or from the WEB
	 * 
	 * */
}
