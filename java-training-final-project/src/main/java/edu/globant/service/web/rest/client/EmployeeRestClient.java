package edu.globant.service.web.rest.client;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.Unirest;

import edu.globant.service.dto.EmployeeDto;

public class EmployeeRestClient {

	public static void main(String[] args) throws Exception {
		String baseUrl = "http://localhost:8080/java-training-web/rest/employees";
		String resultFromGetToBaseUrl = Unirest.get(baseUrl).asString().getBody();
//		String resultFromGetToBaseUrl = Unirest.get(baseUrl + "/{id}")
//				.routeParam("id", "1")
//				.asString().getBody();
		//ObjectMapper mapper = new ObjectMapper();
		//EmployeeDto employeeDto = mapper.readValue(resultFromGetToBaseUrl, EmployeeDto.class);
		//System.out.println(String.format("%s %s", employeeDto.getName(), employeeDto.getType()));
		System.out.println("***************resultFromGetToBaseUrl"+resultFromGetToBaseUrl.toString());
	}
}
