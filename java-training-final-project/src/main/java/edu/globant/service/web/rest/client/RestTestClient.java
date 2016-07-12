package edu.globant.service.web.rest.client;

import com.mashape.unirest.http.Unirest;

public class RestTestClient {

	public static void main(String[] args) throws Exception {
		//String baseUrl = "http://localhost:8080/java-training-web/rest/testrest";
		String baseUrl = "http://localhost:8080/java-training-web/";
		String resultFromGetToBaseUrl = Unirest.get(baseUrl)
				.asString().getBody();
		System.out.println(resultFromGetToBaseUrl);
		String resultFromGetToBaseUrlWithPathVar = Unirest.get(baseUrl + "/{pathVar}")
				.routeParam("pathVar", "Jorge Barrionuevo")
				.asString().getBody();
		System.out.println(resultFromGetToBaseUrlWithPathVar);
	}
}
