package Test.Evernote;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;

public class DriverSingleton {
	private static DriverSingleton instance = null;
	private static WebDriver driver = null;
	private int implicitWaitInSec = 60;
	
	/* DriverSingleton constructor */
	private DriverSingleton() {
		instantiate("chrome");
	}
	
	/* Initializes the web driver*/
	@SuppressWarnings("deprecation")
	public WebDriver instantiate(String Strategy) {
		DriverStrategy driverStrategy = DriverStrategyImplementer.chooseStrategy(Strategy);
		driver = driverStrategy.setStrategy();
		/* Configures general timeout*/
		driver.manage().timeouts().implicitlyWait(implicitWaitInSec, TimeUnit.SECONDS);
		/* Maximizes the driver window*/
		driver.manage().window().maximize();
		return driver;
	}
	
	/* Gets only one instance of singleton or return the current instance 
	 * if there is already one*/
	public static DriverSingleton getInstance() {
		if(instance == null){
			instance = new DriverSingleton();
		}
		
		return instance;
	}
	
	/* Makes the current instance is null and quits driver*/
	public static void closeObjectInstance() {
		instance = null;
		driver.quit();
	}
	
	/* Gets the current driver*/
	public static WebDriver getDriver() {
		return driver;
	}
}
