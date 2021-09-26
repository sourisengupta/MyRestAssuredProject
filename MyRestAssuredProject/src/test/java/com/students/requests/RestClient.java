package com.students.requests;

import com.students.tests.TestBase;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestClient extends TestBase{
	
	public Response doGetRequest(String subPath) {
		return (Response) given()
					.when()
					.get(subPath)
					;
	}
	
	public Response doPostRequest(String uri, Object body) {
		return given()
				.contentType(ContentType.JSON)
				.when()
				.body(body)
				.post(uri)				
				;
	}
}
