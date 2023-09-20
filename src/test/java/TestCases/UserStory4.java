package TestCases;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import DataProviders.DataProviders;
import PageObjects.DBConnection;
import PojoClasses.Vouchers;
import PojoClasses.WorkingClassHero;
import PojoClasses.WorkingClassHeroVoucher;

public class UserStory4 extends DataProviders {
	
	
	@Test(dataProvider = "DataProviderUS4AC1PositiveTests")
	public void TestUS4AC1(String natid,String name,String gender,String birthDate,String deathDate,
			Double salary,int taxPaid,String browniePoints, String voucherName, String voucherType) throws JsonProcessingException {
		
		//this is the main object
		WorkingClassHeroVoucher wch = new WorkingClassHeroVoucher();
		wch.setNatid(natid);
		wch.setName(name);
		wch.setGender(gender);
		wch.setBirthDate(birthDate);
		wch.setDeathDate(deathDate);
		wch.setSalary(salary);
		wch.setTaxPaid(taxPaid);
		
		Vouchers voucher  = new Vouchers();
		voucher.setVoucherName(voucherName);
		voucher.setVoucherType(voucherType);
		//create a List object to add the Voucher object
		List<Vouchers> vouch = new ArrayList<>();
		vouch.add(voucher);
		// add the vouch array to the main object
		wch.setVouchers(vouch);
		
		
		//convert the POJO into JSON Format
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(wch);
	    System.out.println(jsonString);
		
        baseURI = "http://localhost:9997";
		
		//send the request
		given().
			header("Content-Type", "application/json").
			body(wch).
		when().
			post("/api/v1/hero/vouchers").
		then().
		    statusCode(200).
			log().all();
		
		//check if the record is created in database-----AC4
		DBConnection.checkDBforVoucher(voucherName);
		
		
	}
	
	@Test(dataProvider = "DataProviderUS4AC2NegativeTests")
	public void TestUS4AC2(String natid,String name,String gender,String birthDate,String deathDate,
			Double salary,int taxPaid,int browniePoints, String voucherName, String voucherType,String errMessage) throws JsonProcessingException {
		
		//this is the main object
		WorkingClassHeroVoucher wch = new WorkingClassHeroVoucher();
		wch.setNatid(natid);
		wch.setName(name);
		wch.setGender(gender);
		wch.setBirthDate(birthDate);
		wch.setDeathDate(deathDate);
		wch.setSalary(salary);
		wch.setTaxPaid(taxPaid);
		
		Vouchers voucher  = new Vouchers();
		voucher.setVoucherName(voucherName);
		voucher.setVoucherType(voucherType);
		//create a List object to add the Voucher object
		List<Vouchers> vouch = new ArrayList<>();
		vouch.add(voucher);
		// add the vouch array to the main object
		wch.setVouchers(vouch);
		
		
		//convert the POJO into JSON Format
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(wch);
	    System.out.println(jsonString);
		
        baseURI = "http://localhost:9997";
		
		//send the request
		given().
			header("Content-Type", "application/json").
			body(wch).
		when().
			post("/api/v1/hero/vouchers").
		then().
			statusCode(400).
			body("errorMsg",equalTo(errMessage)).
			log().all();
		
		//verify record is not created
		DBConnection.checkDBforVoucher(voucherName);
		
		
	}

}
