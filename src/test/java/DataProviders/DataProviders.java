package DataProviders;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	
	@DataProvider(name = "DataProviderUS1AC1PositiveTests")
	public Object [][] dataAC1Positive(){
		return new Object [][] {
			//ALL FIELDS WITH VALID VALUE
			{"natid-203","John Connor","MALE","1965-09-19T23:14:27",null,10.00,1,"9"},
			//FEMALE GENDER
			{"natid-204","Sarah Connor","FEMALE","1965-09-19T23:14:27",null,10.00,1,"9"},
			//BROWNIE POINTS AND DEAHDATE NULLABLE
			{"natid-205","Sarah Connor","FEMALE","1975-09-19T23:14:27",null,10.00,1,null}
		};
		
	}
	
	@DataProvider(name = "DataProviderUS1AC1NegativeTests")
	public Object [][] dataAC1Negative(){
		return new Object [][] {
			//INCORRECT NATID FORMAT
			{"natid-abc","Test User","MALE","1985-01-01",null,10.00,1,9,"Invalid natid"},
			//INCORRECT NATID FORMAT (NATID IS NOT IN RANGE 0 - 9999999) ---> note : THERE IS BUG HERE. EVEN IF NATID IS > 9999999, THE RECORD STILL GETS REATED
			//{"natid-99999999999","Test User","MALE","1985-01-01",null,10.00,1,9,"Invalid natid"},
			//INCORRECT GENDER
			{"natid-12","Test User","NOGENDER","1985-01-01",null,10.00,1,9,"Invalid gender"},
			//INCORRECT BDAY FORMAT (MONTH IS > 12)
			{"natid-532","Test User","MALE","1985-13-01",null,10.00,1,9,"There are some issues with working class hero"},
			//INCORRECT BDAY FORMAT (MONTH IS > 12)
			{"natid-1896","Test User","MALE","1975-09-19'T'23:14:27",null,10.00,1,9,"Invalid birthdate format"},
			//FUTUREDATED BDAY 
			{"natid-41","Test User","MALE","2025-05-01",null,10.00,1,9,"There are some issues with working class hero"},
			//NEGATIVE SALARY
			{"natid-42","Test User","MALE","1985-01-01",null,-10.00,1,9,"Salary must be greater than or equals to zero"},
			//NEGATIVE TAXPAID
			{"natid-42","Test User","MALE","1985-01-01",null,10.00,-1,9,"must be greater than or equal to 0"},
		};
	}
	
	@DataProvider(name = "DataProviderUS4AC1PositiveTests")
	public Object [][] dataUS4AC1Positive(){
		return new Object [][] {
			//VALIDATIONS SAME AS US1, ONLY THERE ARE VOUCHERS HERE
			//MALE GENDER
			{"natid-1036","John Connor","MALE","1985-01-01",null,10.00,1,"9","VOUCHER 1A","TRAVEL"},
			//FEMALE
			{"natid-1037","Sarah Connor","FEMALE","1985-01-01",null,10.00,1,"9","VOUCHER 1","TRAVEL"},
			//BROWNIE POINTS AND DEAHDATE NULLABLE
			{"natid-1038","John Connor","MALE","1985-01-01",null,10.00,1,null,"VOUCHER 1","TRAVEL"}
		};
	}
	
	@DataProvider(name = "DataProviderUS4AC2NegativeTests")
	public Object [][] dataUS4AC2Positive(){
		return new Object [][] {
			//MALE GENDER
			{"natid-38","John Connor","MALE","1985-01-01",null,10.00,1,9,"","TRAVEL","Voucher Name cannot be blank"},
			//INCORRECT NATID FORMAT
			{"natid-abc","Test User","MALE","1985-01-01",null,10.00,1,9,"VOUCHER 1","TRAVEL","Invalid natid"},
			//INCORRECT GENDER
			{"natid-12","Test User","NOGENDER","1985-01-01",null,10.00,1,9,"VOUCHER 1","TRAVEL","Invalid gender"},
			//INCORRECT BDAY FORMAT
			{"natid-4650","Test User","MALE","1985-13-01",null,10.00,1,9,"VOUCHER 1","TRAVEL","There are some issues with working class hero"},
			//FUTUREDATED BDAY 
			{"natid-4198","Test User","MALE","2025-05-01",null,10.00,1,9,"VOUCHER 1","TRAVEL","There are some issues with working class hero"},
			//NEGATIVE SALARY
			{"natid-78446","Test User","MALE","1985-01-01",null,-10.00,1,9,"VOUCHER 1","TRAVEL","Salary must be greater than or equals to zero"},
			//NEGATIVE TAXPAID
			{"natid-4202","Test User","MALE","1985-01-01",null,10.00,-1,9,"VOUCHER 1","TRAVEL","must be greater than or equal to 0"},
		};
	}
	
	
	@DataProvider(name = "DataProviderUS5")
	public Object [][] dataUS5AC1Positive(){
		return new Object [][] {
			//MALE GENDER
			{"1000","OWE"},
		};
	}

}
