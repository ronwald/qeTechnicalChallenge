package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class WorkingClassHeroPage {
	
	WebDriver driver;
	
	public WorkingClassHeroPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//object locators
	By userName_textBox = By.id("username-in");
	By password_textBox = By.id("password-in");
	By submit_button = By.xpath("/html/body/form/div[3]/div[2]/input");
	By uploadCSVfile = By.xpath("//*[@id='upload-csv-file']");
	By addHeroButton = By.id("dropdownMenuButton2");
	By uploadCsvFile = By.linkText("Upload a csv file");
	By create_button = By.xpath("//*[contains(text(),'Create')]");
	By unsuccessfulNotif = By.xpath("//*[text()='Unable to create hero!']");
	By successfulNotif = By.xpath("//*[text()='Created Successfully!']");
	By generateTaxReliefFile_button = By.xpath("//*[text()='Generate Tax Relief File']");
	
	
	//functions
		public void enterTextUserName(String userName) {
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			driver.findElement(userName_textBox).sendKeys(userName);
		}
		
		public void enterTextPassword(String passWord) {
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			driver.findElement(password_textBox).sendKeys(passWord);
		}
		

		public void clickSubmit() {
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			driver.findElement(submit_button).click();
		}
		
		public void clickUploadCsvFile() {
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			driver.findElement(addHeroButton).click();
			driver.findElement(uploadCsvFile).click();
			
		}
		
		public void uploadCsvFileFromRoot(String fileName) {
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			String csvFile = System.getProperty("user.dir")+"\\" + fileName;
			System.out.println(csvFile);
			driver.findElement(uploadCSVfile).sendKeys(csvFile);
		}
		
		public void clickButtonByText() {
			driver.findElement(create_button).click();
			
		}
		
		public void verifySuccessConfirmationMsgDisplayed(String text) {
			String bodyText = driver.findElement(successfulNotif).getText();
			Assert.assertTrue(bodyText.contains(text));
		}
		
		public void verifyUnsucessConfirmationMsgDisplayed(String text) {
			String bodyText = driver.findElement(unsuccessfulNotif).getText();
			Assert.assertTrue(bodyText.contains(text));
		}
		
		public void clickGenerateTaxReliefButton() {
			driver.findElement(generateTaxReliefFile_button).click();
			
		}
	
	

}
