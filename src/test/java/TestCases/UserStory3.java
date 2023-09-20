package TestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import PageObjects.WorkingClassHeroPage;

public class UserStory3 {
	
	WebDriver driver = new ChromeDriver();
	WorkingClassHeroPage wchp = new WorkingClassHeroPage(driver);
	
	/* THERE SEEMS TO BE BUG. 
	 * NOTHING HAPPENS AFTER I CLICK 'GENERATE TAX RELIEF FILE' BUTTON
	*/
	
	@Test
	public void testAC1AndAC2() {
		driver.get("http://localhost:9997/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		wchp.enterTextUserName("bk");
		wchp.enterTextPassword("bk");
		wchp.clickSubmit();
		wchp.clickGenerateTaxReliefButton();
		driver.close();	

		
	}

}
