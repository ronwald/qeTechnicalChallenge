package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import PageObjects.WorkingClassHeroPage;
import java.time.Duration;

public class UserStory2 {
	
	//WebDriver driver = new ChromeDriver();
	//WorkingClassHeroPage wchp = new WorkingClassHeroPage(driver);
	
	@Test 
	public void testAC1AndAC2() {
		//THIS IS AC1 AND AC2 : SUCESSFUL CREATION OF WORKING HEROES USING CSV FILE
		WebDriver driver = new ChromeDriver();
		WorkingClassHeroPage wchp = new WorkingClassHeroPage(driver);
		driver.get("http://localhost:9997/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wchp.enterTextUserName("clerk");
		wchp.enterTextPassword("clerk");
		wchp.clickSubmit();
		wchp.clickUploadCsvFile();
		wchp.uploadCsvFileFromRoot("hero.csv");
		wchp.clickButtonByText();
		wchp.verifySuccessConfirmationMsgDisplayed("Created Successfully!");
		driver.close();		
		
		
	}
	
	@Test
	public void testAC4() {
		//THIS IS AC1 AND AC4 : UNSUCESSFUL CREATION OF WORKING HEROES USING CSV FILE
		WebDriver driver = new ChromeDriver();
		WorkingClassHeroPage wchp = new WorkingClassHeroPage(driver);
		driver.get("http://localhost:9997/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wchp.enterTextUserName("clerk");
		wchp.enterTextPassword("clerk");
		wchp.clickSubmit();
		wchp.clickUploadCsvFile();
		wchp.uploadCsvFileFromRoot("heroUnsuccessful.csv");
		wchp.clickButtonByText();
		wchp.verifyUnsucessConfirmationMsgDisplayed("Unable to create hero!");
		driver.close();	
		
	}
	
	

}
