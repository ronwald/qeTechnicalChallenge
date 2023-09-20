package TestCases;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class UserStory6 {
	
	
	@Test
	public void TestUS6AC1() {
		
		baseURI = "http://localhost:9997";
		
		//send the request
		given().
			header("Content-Type", "application/json").
		when().
			get("api/v1/voucher/by-person-and-type").
		then().
			log().all();
		
	}

}
