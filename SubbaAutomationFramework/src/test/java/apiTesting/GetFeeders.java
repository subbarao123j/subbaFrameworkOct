package apiTesting;

import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import junit.framework.Assert;

public class GetFeeders {
	
	
	
	
	@Test
	public void testStatusCode() {
		
		
		int code = RestAssured
		.given()
		.header("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpYXQiOjE1NzE4OTAwMTYsImlzcyI6IlBTSSBJbmNvbnRyb2wgU2RuIEJoZCIsIm5hbWUiOiJtdm9yciIsInJvbGUiOiIzcmQgcGFydHkgc3lzdGVtIn0.K-iFraX5b5J6VOsEaQez4XSIJCRND1EHHF0AvTXRfcc")
		.get("http://10.9.82.13:9001/mvorr/api/v1/get-feeders")
		.getStatusCode();
		System.out.println(code);
		
		
		
		Assert.assertEquals(code, 200);
				
		}
	
	
	@Test
	public void testContent() {
		
		
		String  data = RestAssured
		.given()
		.header("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpYXQiOjE1NzE4OTAwMTYsImlzcyI6IlBTSSBJbmNvbnRyb2wgU2RuIEJoZCIsIm5hbWUiOiJtdm9yciIsInJvbGUiOiIzcmQgcGFydHkgc3lzdGVtIn0.K-iFraX5b5J6VOsEaQez4XSIJCRND1EHHF0AvTXRfcc")
		.get("http://10.9.82.13:9001/mvorr/api/v1/get-feeders")
		.getBody().asString();
		
	
		System.out.println(data);
		
		JsonElement jsonElement = new Gson().fromJson(data, JsonElement.class);
		JsonArray jsonArray = jsonElement.getAsJsonArray();
		
		int data1=jsonArray.size();
		System.out.println(data1);
		
		Assert.assertTrue(jsonElement.isJsonArray());
		for(JsonElement item : jsonArray)
		{
			JsonObject o = item.getAsJsonObject();
			//System.out.println(o.get("substationType"));
		}
	}
	

}
