package Test.Evernote;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login {
	DriverSingleton driverSingleton = DriverSingleton.getInstance();
	WebDriver driver = DriverSingleton.getDriver();	
	
	@BeforeTest
	public void Setup() {
		driver.get("https://evernote.com/");//http://10.105.72.20:8055/Account/login");
	}
	
	@Test(priority = 0)
	public void LoginWithNoCredentials() throws InterruptedException {
		
		String ExpectedInvalidLoginMSg = "Required data missing";
		
		WebElement LoginLink = driver.findElement(By.xpath("/html/body/header/div[1]/div/nav[2]/ul/li[2]/a"));
		LoginLink.click();
		
		WebElement EmailField = driver.findElement(By.id("username"));
		EmailField.clear();

		WebElement LoginButton = driver.findElement(By.id("loginButton"));
		LoginButton.click();
		
		WebElement VerificationMsg = driver.findElement(By.id("responseMessage"));

		if(VerificationMsg.isDisplayed())
		{
			assertEquals(VerificationMsg.getText(), ExpectedInvalidLoginMSg);
		}
		
		driver.navigate().refresh();
	}

	
	@Test(priority = 1)
	public void LoginFunc()
	{
		String ValidEmail = "eslamaboutaleb@yahoo.com";
		String Password = "123123123";
		String ExpectedHomeTabName = "Home - Evernote";

		WebElement EmailField = driver.findElement(By.id("username"));
		EmailField.clear();
		EmailField.sendKeys(ValidEmail);
		
		WebElement LoginButton = driver.findElement(By.id("loginButton"));
		LoginButton.click();
		
		WebElement PassField = driver.findElement(By.id("password"));
		PassField.clear();
		PassField.sendKeys(Password);

		LoginButton.click();
		
		if((driver.findElements(By.id("qa-GENERIC_LIGHTBOX_DIALOG")).size()==1) || 
				(driver.findElements(By.id("qa-TASK_INTRO_MODAL")).size()==1))
		{
			String HomeTabTitle = driver.getTitle();
			assertEquals(HomeTabTitle, ExpectedHomeTabName);
		}
		
		
		
	}
	
	
	@AfterTest
	public void TearDown()
	{
		driver.quit();
	}
}
