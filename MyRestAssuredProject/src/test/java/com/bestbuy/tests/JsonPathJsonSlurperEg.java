package com.bestbuy.tests;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.gson.JsonElement;
import com.jayway.jsonpath.JsonPath;

import io.restassured.RestAssured;
/*git clone https://github.com/bestbuy/api-playground/
cd api-playground
npm install
npm start
# Best Buy API Playground started at http://localhost:3030
*/public class JsonPathJsonSlurperEg {
	static String jsonResponse;
	
	@BeforeSuite
	public void initialize() {
		RestAssured.baseURI="http://localhost";
		RestAssured.port=3030;
		jsonResponse = RestAssured.given().when().get("/products").asString();
	}
	@BeforeTest
	public void print() {
		System.out.println("-----Starting the test method------");
	}
	@AfterTest
	public void printAgain() {
		System.out.println("-----Ending the test method------");
	}
	
	//https://jsonpath.herokuapp.com/
	@Test(enabled=false)
	public void  getRoot() {
		String rootElement = JsonPath.read(jsonResponse, "$").toString();
		System.out.println(rootElement);
	}
	@Test(enabled=false)
	public void  getTotalFromResp() {
		int total = JsonPath.read(jsonResponse, "$.total"); 
		System.out.println("total="+total);
	}
	@Test(enabled=false)
	public void  getAllDataElement() {
		List<HashMap<String,Object>> data = JsonPath.read(jsonResponse, "$.data");
		data.stream().forEach(System.out::println);
	}
	@Test(enabled=false)
	public void  getFirstDataElement() {
		Map<String,Object> data = JsonPath.read(jsonResponse, "$.data[0]");
		System.out.println("data[0]="+data.toString());
	}
	@Test(enabled=false)
	public void  getLastDataElement() {
		Map<String,Object> data = JsonPath.read(jsonResponse, "$.data[-1]");
		System.out.println("data[last]="+data.toString());
	}
	@Test(enabled=false)
	public void  getAllIdsUnderData() {
		List<String> data = JsonPath.read(jsonResponse, "$.data[*].id");
		System.out.println("Ids="+data.toString());
	}
	@Test(enabled=true)
	public void  getProductNamesWhosePriceIsGreaterThan5() {
		List<String> data = JsonPath.read(jsonResponse, "$.data[?(@.price > 5)]");
		System.out.println("data="+data.toString());
	}
	
}
