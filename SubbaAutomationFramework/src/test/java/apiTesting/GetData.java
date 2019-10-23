package apiTesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import junit.framework.Assert;

public class GetData {
	
	
	
	
	@Test
	public void testStatusCode() {
		
		
		int code = RestAssured
		.given()
		.get("https://reqres.in/api/users?page=2")
		.getStatusCode();
		System.out.println(code);
		
		Assert.assertEquals(code, 200);
		
		
		
		
	}
	
	@Test
	public void testContent() {
		
		
		String  data = RestAssured
		.given()
		.get("https://reqres.in/api/users?page=2")
		.getBody().asString();
		
		System.out.println(data);
		
		Assert.assertTrue(data.contains("Michael"));
		
		//Assert.assertEquals(data, 200);
		
		
		
		
	}
	

}
