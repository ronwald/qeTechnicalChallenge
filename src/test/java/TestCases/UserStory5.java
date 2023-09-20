package TestCases;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import DataProviders.DataProviders;

public class UserStory5 extends DataProviders  {
	
	
	@Test(dataProvider = "DataProviderUS5")
	public void TestUS6AC1(String id, String status) {
		
		baseURI = "http://localhost:9997";
		
		//send the request
		given().
			header("Content-Type", "application/json").
		when().
			get("/api/v1/hero/owe-money?natid=" +id).
		then().
			log().all();
		
	}

}
