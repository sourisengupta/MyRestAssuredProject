package com.students.tests;
import org.testng.annotations.BeforeClass;
import com.students.utils.PropertyReader;

import io.restassured.RestAssured;
public class TestBase {
	/*
	 * The singleton design pattern is a design pattern which 
	 * restricts the instantiation of a class to single object
	 *   1. Make the constructor private
	 *   2. Create a static method to get the instance
	 *   3. Create a private static member variable 
	 */
	
	public static PropertyReader property;
	
	@BeforeClass
	public void initUrl() {
		property = PropertyReader.getInstance();
		
		RestAssured.baseURI = property.getProperty("baseURI");
		RestAssured.port = Integer.valueOf(property.getProperty("port"));
		
		System.out.println(RestAssured.baseURI);
		System.out.println(RestAssured.baseURI.getClass().getSimpleName());
		System.out.println(RestAssured.port);
		System.out.println(((Object)RestAssured.port).getClass().getSimpleName());
		//RestAssured.baseURI="http://localhost:8080/student";
		//RestAssured.port=8080;
		
		
	}
}
