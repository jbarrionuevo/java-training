package edu.globant.day9.service.exercices.soap;

import javax.xml.ws.Endpoint;

public class SoapPublisher {
	
	//run this as a Java app and go to the url http://localhost:8888/ws/contact?wsdl,
	//where you should see the generated wsdl
	public static void main(String[] args) {
        Endpoint.publish("http://localhost:8888/ws/contact", new ContactServiceImpl());  
   }
	
}
