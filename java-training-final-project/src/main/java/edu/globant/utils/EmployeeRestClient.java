package edu.globant.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.Unirest;

import edu.globant.service.dto.EmployeeDto;

public class EmployeeRestClient {

	public static void main(String[] args) throws Exception {
		String baseUrl = "http://localhost:8080/java-training-web/rest/employee";
		String resultFromGetToBaseUrl = Unirest.get(baseUrl + "/{id}")
				.routeParam("id", "1")
				.asString().getBody();
		ObjectMapper dtoMapper = new ObjectMapper();
		EmployeeDto contactDto = dtoMapper.readValue(resultFromGetToBaseUrl, EmployeeDto.class);
		System.out.println(String.format("%s %s", contactDto.getName(), contactDto.getType()));
	}
}
