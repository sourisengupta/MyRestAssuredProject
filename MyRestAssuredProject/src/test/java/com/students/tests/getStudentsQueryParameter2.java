package com.students.tests;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class getStudentsQueryParameter2 {
	
	
	@Test
	public void getSingleCSStudent() {
		
		// Get a student from computer science
		
		
		given()
		.queryParam("programme", "Computer Science")
		.queryParam("limit", 1)
		.when()
		.get("http://localhost:8080/student/list")
		;
		
	
	}
}
