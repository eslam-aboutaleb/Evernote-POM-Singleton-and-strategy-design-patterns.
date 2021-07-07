package Test.Evernote;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class chrome implements DriverStrategy{

	public WebDriver setStrategy(){
		String chromepath = System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		ChromeOptions chromeOptionsmod = new ChromeOptions();

		System.setProperty("webdriver.chrome.driver", chromepath);
		chromeOptionsmod.setExperimentalOption("useAutomationExtension", false);
		chromeOptionsmod.addArguments("--no-sandbox");
		chromeOptionsmod.addArguments("–disable-notifications");
		
		return new ChromeDriver(chromeOptionsmod);
	}
}
