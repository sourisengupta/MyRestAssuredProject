package com.students.tests;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

public class getStudentsQueryParameter extends TestBase {
	
	
	@Test(enabled=false)
	public void getSingleCSStudent() {		
		// Get a student from computer science		
		Response response =
		given()
		.queryParam("programme", "Computer Science")
		.queryParam("limit", 1)
		.when()
		.get("http://localhost:8081/student/list")
		;
		
		//response.prettyPrint();
	}
	// Get single CS student with different way
	@Test(enabled=true)
	public void getSingleCSStudent1() {
		Map<String, Object> mapQuery = new HashMap<String, Object>();
		mapQuery.put("programme", "Computer Science");
		mapQuery.put("limit", 1);
		Response response = given()
		.queryParams(mapQuery)
		.when()
		.get("http://localhost:8081/student/list")
		;
		response.prettyPrint();
	}
	@Test(enabled=true)
	public void getStudentWithPathParam() {
		
		Response response = 
				given()
				.pathParam("id", 1)
				.when()
				.get("{id}")   // URL is set to Test Base 
				;
		response.prettyPrint();
		
		// RestAssured.reset(); will reset all the static method and values that we set already
	}
}
