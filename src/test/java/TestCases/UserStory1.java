package TestCases;


import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import PojoClasses.WorkingClassHero;
import io.restassured.RestAssured;
import DataProviders.DataProviders;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import PageObjects.DBConnection;

import java.sql.ResultSet;


//docker-compose -f C:\Users\ECQ1033\Desktop\CDS\local-docker-compose.yml up -d
//java -Dspring.profiles.active=prd -jar C:\Users\ECQ1033\Desktop\CDS\OppenheimerProjectDev.jar
public class UserStory1 extends DataProviders {
	
	
	@Test(dataProvider = "DataProviderUS1AC1PositiveTests")
	public void TestUS1AC1(String natid,String name,String gender,String birthDate,String deathDate,
			Double salary,int taxPaid,String browniePoints) throws JsonProcessingException {
		//AC1 AND AC2
		WorkingClassHero wch = new WorkingClassHero();
		wch.setNatid(natid);
		wch.setName(name);
		wch.setGender(gender);
		wch.setBirthDate(birthDate);
		wch.setDeathDate(deathDate);
		wch.setSalary(salary);
		wch.setTaxPaid(taxPaid);
		
		//convert the POJO into JSON Format so that it can be sent as json request
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(wch);
	    //System.out.println(jsonString);
		
        baseURI = "http://localhost:9997";
		
		//send the request
		given().
			header("Content-Type", "application/json").
			body(wch).
		when().
			post("/api/v1/hero").
		then().
			statusCode(200).
			log().all();
		
		//check if the record is created in database-----AC4
		DBConnection.checkDBforNatid(natid);
		
		
	}
	
	
	@Test(dataProvider = "DataProviderUS1AC1NegativeTests")
	public void TestUS1AC2(String natid,String name,String gender,String birthDate,String deathDate,
			Double salary,int taxPaid,int browniePoints,String errMessage) throws JsonProcessingException {
		//AC4
		
		WorkingClassHero wch = new WorkingClassHero();
		wch.setNatid(natid);
		wch.setName(name);
		wch.setGender(gender);
		wch.setBirthDate(birthDate);
		wch.setDeathDate(deathDate);
		wch.setSalary(salary);
		wch.setTaxPaid(taxPaid);
		
		//convert the POJO into JSON Format
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(wch);
	    //System.out.println(jsonString);
		
        baseURI = "http://localhost:9997";
		
		//send the request
		given().
			header("Content-Type", "application/json").
			body(wch).
		when().
			post("/api/v1/hero").
		then().
		    //VERIFY STATUS CODE IS 400
			statusCode(400).
			body("errorMsg",equalTo(errMessage)).
			log().all();
		
		//verify if the record is not created in database-----AC4
		DBConnection.checkDBforNatid(natid);
		
	}
	
	

}
