package com.students.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import com.github.javafaker.Faker;
import com.students.pojo.Student;
import com.students.requests.RestClient;
import com.students.tests.TestBase;

public class CrudTest extends TestBase{
	
	RestClient restClient = new RestClient();
	Faker fake = new Faker();
	
	@Test
	public void getAllStudents() {
		
		restClient.doGetRequest("/list").then().statusCode(200);
		//System.out.println("getAllStudents----------"+response.asPrettyString());
	}
	
	@Test
	public void createNewStudent() {
		Student student = new Student();
		List<String> courses = new ArrayList<String>();
		courses.add("MBA");
		courses.add("BTECH");
		student.setFirstName(fake.name().firstName());
		student.setLastName(fake.name().lastName());
		student.setEmail(fake.internet().emailAddress());
		student.setProgramme("Java");
		student.setCourses(courses);
		restClient.doPostRequest("", student).then().statusCode(201);
	}
}
